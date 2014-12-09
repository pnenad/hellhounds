package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.abilities.effects.EffectType;
import com.hellhounds.battlefree.game.units.Unit;

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
