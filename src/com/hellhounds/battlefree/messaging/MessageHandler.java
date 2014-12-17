/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hellhounds.battlefree.messaging;

import com.hellhounds.battlefree.game.Game;
import com.hellhounds.battlefree.game.Player;
import com.hellhounds.battlefree.game.units.*;

import java.util.HashMap;
import java.util.Random;

/**
 *
 */
public class MessageHandler{

    public MessageHandler()
    {
    }

    public static Player handleRequest(RequestMessage message, Player opponent, HashMap<Long, Game> games)
    {
        Unit[] units = new Unit[message.getUnits().length];
        int index = 0;

        for(JsonUnit jsonUnit : message.getUnits())
        {
            units[index++] = getUnit(jsonUnit.getUnitName());
        }

        Player player = new Player(message.getUsername(), units[0], units[1], units[2]);


        if(opponent != null && !opponent.getUsername().equalsIgnoreCase(player.getUsername()))
        {
            // Simple way of generating gameID, this functionality should be moved to database further on.
            Random rand = new Random(564654846);
            long gameID = rand.nextLong();

            games.put(gameID, new Game(player, opponent, gameID));

            System.out.println("GAMEID: " + gameID);

            return null;
        }
        else return player;
    }

    /**
     * Discerns if the sender of the message is player1 or player2
     * in the Game, then resolves targetting based on message.
     * @param message
     */
    public static void handleTargets(TargetsMessage message, Player player1, Player player2)
    {
        if(message.getFromUsername().equalsIgnoreCase(player1.getUsername()))
        {
            addTargets(player1, player2, message.getActions());
        }
        else
        {
            addTargets(player2, player1, message.getActions());
        }
    }

    /**
     * Loops through JsonUnits and tries to fetch a Game Unit
     * based on its name and player.
     * If successful and the JsonUnit is marked as activated,
     * the Game Unit is set as activated as well.
     * Steps further into mapTargets.
     * Only locally called from resolveTargetsMessage.
     * @param player
     * @param opponent
     * @param units
     */
    private static void addTargets(Player player, Player opponent, JsonUnit[] units)
    {
        for(JsonUnit jsonUnit : units)
        {
            Unit unit = player.getUnit(jsonUnit.getUnitName());

            if(unit != null && jsonUnit.isActivated())
            {
                unit.getAbility().setActivated(true);
                mapTargets(player, opponent, unit, jsonUnit);
            }
        }
    }

    /**
     * A fairly inelegant method.
     * Used for mapping targets from a message to the
     * actual Units in the active Game.
     * May need some rework.
     * @param player
     * @param opponent
     * @param unitSource
     * @param jsonUnitSource
     */
    private static void mapTargets(Player player, Player opponent, Unit unitSource, JsonUnit jsonUnitSource)
    {

        if(jsonUnitSource.getPrimaryTargets().length > 0)
        {
            for(Target target : jsonUnitSource.getPrimaryTargets())
            {
                String targetUnitName = target.getTargetUnitName();
                // If the target of the ability and source of the ability is owned by the same player
                if(target.getTargetUsername().equalsIgnoreCase(player.getUsername()))
                {
                    unitSource.addPrimaryTarget(player.getUnit(targetUnitName));
                }
                else
                {
                    unitSource.addPrimaryTarget(opponent.getUnit(targetUnitName));
                }
            }
        }

        if(jsonUnitSource.getSecondaryTargets().length > 0)
        {
            for(Target target : jsonUnitSource.getSecondaryTargets())
            {
                String targetUnitName = target.getTargetUnitName();
                // If the target of the ability and source of the ability is owned by the same player
                if(target.getTargetUsername().equalsIgnoreCase(player.getUsername()))
                {
                    unitSource.addSecondaryTarget(player.getUnit(targetUnitName));
                }
                else
                {
                    unitSource.addSecondaryTarget(opponent.getUnit(targetUnitName));
                }
            }
        }
    }

    public static Unit getUnit(String unitName) {
        switch (unitName) {
            case "Archer":
                return new Archer();
            case "Barbarian":
                return new Barbarian();
            case "Catapult":
                return new Catapult();
            case "Defender":
                return new Defender();
            case "Dwarf":
                return new Dwarf();
            case "Footsoldier":
                return new Footsoldier();
            case "Golem":
                return new Golem();
            case "Mage":
                return new Mage();
            case "Mushroom":
                return new Mushroom();
            case "Orc":
                return new Orc();
            case "Skeleton":
                return new Skeleton();
            case "Supplycart":
                return new Supplycart();
            case "Thief":
                return new Thief();
            case "Vampire":
                return new Vampire();
            default:
                return null;
        }
    }
}
