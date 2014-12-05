package com.hellhound.battlefree.game;

import com.hellhound.battlefree.game.units.Unit;

public class PlayerBuilder{

    private Player player;

    public PlayerBuilder(String username)
    {
        player = new Player(username);
    }

    public PlayerBuilder unit1(Unit unit)
    {
        player.setUnit1(unit);
        return this;
    }
    
    public PlayerBuilder unit2(Unit unit)
    {
        player.setUnit2(unit);
        return this;
    }

    public PlayerBuilder unit3(Unit unit)
    {
        player.setUnit3(unit);
        return this;
    }

    public PlayerBuilder gold(int amount)
    {
        player.setGold(amount);
        return this;
    }

    public PlayerBuilder steel(int amount)
    {
        player.setSteel(amount);
        return this;
    }

    public PlayerBuilder crystal(int amount)
    {
        player.setCrystal(amount);
        return this;
    }

    public Player create()
    {
        return this.player;
    }
}
