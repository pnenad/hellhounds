package com.hellhounds.battlefree.messaging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hellhounds.battlefree.game.Game;
import com.hellhounds.battlefree.game.Player;
import com.hellhounds.battlefree.game.units.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 */
public class MessageHandler{

    public MessageHandler()
    {
    }

    public Player handleRequest(RequestMessage message, Player opponent, HashMap<Long, Game> games)
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

    private Unit getUnit(String unitName) {
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
