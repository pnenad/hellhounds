package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.effects.EffectType;
import com.hellhounds.battlefree.game.units.Unit;
import com.hellhounds.battlefree.messaging.JsonUnit;
import com.hellhounds.battlefree.messaging.Message;
import com.hellhounds.battlefree.messaging.Target;
import com.hellhounds.battlefree.messaging.TargetsMessage;

public class Game implements Runnable{

    private Player player1;
    private Player player2;
    private long gameID;
    private int roundNr;
    // 0 = Active game, 1 = player 1 won, 2 = player 2 won, 3 = Draw
    private int winStatus;

    public Game(Player player1, Player player2, long gameID)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.gameID = gameID;
        this.roundNr = 0;
        this.winStatus = 0;
    }

    /**
     * Discerns if the sender of the message is player1 or player2
     * in the Game, then resolves targetting based on message.
     * @param message
     */
    public void resolveTargetsMessage(TargetsMessage message)
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
    private void addTargets(Player player, Player opponent, JsonUnit[] units)
    {
        for(JsonUnit jsonUnit : units)
        {
            Unit unit = player.getUnitMap().get(jsonUnit.getUnitName());

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
    private void mapTargets(Player player, Player opponent, Unit unitSource, JsonUnit jsonUnitSource)
    {
        if(jsonUnitSource.getPrimaryTargets().length > 0)
        {
            for(Target target : jsonUnitSource.getPrimaryTargets())
            {
                String targetUnitString = target.getTargetUnitName();
                // If the target of the ability and source of the ability is owned by the same player
                if(target.getTargetUsername().equalsIgnoreCase(player.getUsername()))
                {
                    unitSource.getAbility().getPrimary().addTarget(player.getUnitMap().get(targetUnitString));
                }
                else
                {
                    unitSource.getAbility().getPrimary().addTarget(opponent.getUnitMap().get(targetUnitString));
                }
            }
        }

        if(jsonUnitSource.getSecondaryTargets().length > 0)
        {
            for(Target target : jsonUnitSource.getSecondaryTargets())
            {
                String targetUnitString = target.getTargetUnitName();
                // If the target of the ability and source of the ability is owned by the same player
                if(target.getTargetUsername().equalsIgnoreCase(player.getUsername()))
                {
                    unitSource.getAbility().getSecondary().addTarget(player.getUnitMap().get(targetUnitString));
                }
                else
                {
                    unitSource.getAbility().getSecondary().addTarget(opponent.getUnitMap().get(targetUnitString));
                }
            }
        }
    }

    public void cleanup()
    {
        Player[] players = {player1, player2};

        for(Player player : players)
        {
            Unit[] units = player.getUnits();
            armorCleanup(player, units);
            healthCleanup(player, units);
            player.setLoss(checkForLoser(player, units));
        }

        endstep(player1, player2);

    }
        
    private void endstep(Player player1, Player player2)
    {
        boolean player1Loss = player1.getLoss();
        boolean player2Loss = player2.getLoss();

        if(!player1Loss && player2Loss) this.winStatus = 1;

        else if(player1Loss && !player2Loss) this.winStatus = 2;

        else if(player1Loss && player2Loss) this.winStatus = 3;

        else
        {
            roundNr++;
            System.out.println(toString());
            player1.generateResource();
            player2.generateResource();
        }
    }

    private void armorCleanup(Player player, Unit[] units)
    {
        for(Unit unit : units)
        {
            unit.setArmor(0);
        }
    }

    private void healthCleanup(Player player, Unit[] units)
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
                unit.setAlive(false);
            }
        }
    }

    private boolean checkForLoser(Player player, Unit[] units)
    {
        for(Unit unit : units)
        {
            if(!unit.isAlive())
                continue;

            return false;
        }

        return true;
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
        String newRound = "Round: " + roundNr + ".\n";
        String line = "------------------------- RESOURCES --------------------\n";
        return newRound + line;
    }



    public Player getPlayer1() { return player1; }
    public void setPlayer1(Player player1){ this.player1 = player1; }

    public Player getPlayer2() { return player2; }
    public void setPlayer2(Player player2){ this.player2 = player2; }

    public long getGameID() { return gameID; }
    public void setGameID(long gameID){ this.gameID = gameID; }

    public int getRoundNr() { return roundNr; }
    public void setRoundNr(int roundNr){ this.roundNr = roundNr; }

    public int getWinStatus() { return winStatus; }
    public void setWinStatus(int winStatus){ this.winStatus = winStatus; }

    @Override
    public void run() {
        System.out.println("Hello Kitty!");
    }
}
