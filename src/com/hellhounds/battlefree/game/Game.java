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
package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.effects.EffectType;
import com.hellhounds.battlefree.game.units.Unit;
import com.hellhounds.battlefree.messaging.MessageHandler;
import com.hellhounds.battlefree.messaging.TargetsMessage;

public class Game{

    private Player player1;
    private Player player2;
    private long gameID;
    private int roundNr;
    // 0 = Active game, 1 = player 1 won, 2 = player 2 won, 3 = Draw
    private int gameState;

    public Game(Player player1, Player player2, long gameID)
    {
        this.roundNr = 1;
        System.out.println(toString());
        this.player1 = player1;
        this.player2 = player2;
        this.gameID = gameID;
        this.gameState = 0;
    }

    public void cleanup()
    {
        Player[] players = {player1, player2};

        for(Player player : players)
        {
            Unit[] units = player.getUnits();
            armorCleanup(units);
            healthCleanup(units);
            targetsCleanup(units);
            player.setLoss(checkForLoser(units));
        }

        endstep(player1, player2);
    }

    public void resolveTargetMessage(TargetsMessage message)
    {
        MessageHandler.handleTargets(message, player1, player2);
    }

    public void resolveEffect(EffectType type)
    {
        Player[] players = {player1, player2};

        for(Player player : players)
        {
            Unit[] units = player.getUnits();

            for(Unit unit : units)
            {
                if(unit.getAbility().isActivated())
                {
                    EffectType primary = unit.getAbility().getPrimary().getType();
                    EffectType secondary = unit.getAbility().getSecondary().getType();

                    if(primary.equals(type))
                        unit.getAbility().getPrimary().applyEffect(unit);

                    if(secondary.equals(type))
                        unit.getAbility().getSecondary().applyEffect(unit);
                }
            }
        }
    }

    @Override
    public String toString()
    {
        String resource = "RESOURCES:\n";
        String line = "------------------------- ROUND" + " " + roundNr + "--------------------\n";
        return line + resource;
    }

    // ------------------- Private  ----------------------

    private void endstep(Player player1, Player player2)
    {
        boolean player1Loss = player1.getLoss();
        boolean player2Loss = player2.getLoss();

        if(!player1Loss && player2Loss) this.gameState = 1;

        else if(player1Loss && !player2Loss) this.gameState = 2;

        else if(player1Loss && player2Loss) this.gameState = 3;

        else
        {
            roundNr++;
            System.out.println(toString());
            player1.generateResource();
            player2.generateResource();
        }
    }

    private void armorCleanup(Unit[] units)
    {
        for(Unit unit : units)
        {
            unit.setArmor(0);
        }
    }

    private void healthCleanup(Unit[] units)
    {
        for(Unit unit : units)
        {
            int currentHealth = unit.getCurrentHealth();

            if(unit.getMaxHealth() < currentHealth)
            {
                unit.setCurrentHealth(unit.getMaxHealth());
            }

            else if(currentHealth <= 0)
            {
                unit.setCurrentHealth(0);
                unit.setAlive(false);
            }
        }
    }

    private void targetsCleanup(Unit[] units)
    {
        for(Unit unit :units)
        {
            unit.getAbility().getPrimary().removeTargets();
            unit.getAbility().getSecondary().removeTargets();
        }
    }

    private boolean checkForLoser(Unit[] units)
    {
        for(Unit unit : units)
        {
            if(!unit.isAlive())
                continue;

            return false;
        }
        return true;
    }

    // ------------------------- Get & Set -------------------------

    public Player getPlayer1() { return player1; }
    public void setPlayer1(Player player1){ this.player1 = player1; }

    public Player getPlayer2() { return player2; }
    public void setPlayer2(Player player2){ this.player2 = player2; }

    public long getGameID() { return gameID; }
    public void setGameID(long gameID){ this.gameID = gameID; }

    public int getRoundNr() { return roundNr; }
    public void setRoundNr(int roundNr){ this.roundNr = roundNr; }

    public int getGameState() { return gameState; }
    public void setWinStatus(int gameState){ this.gameState = gameState; }

}
