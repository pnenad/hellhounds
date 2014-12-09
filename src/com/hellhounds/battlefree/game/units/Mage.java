package com.hellhounds.battlefree.game.units;


import com.hellhounds.battlefree.game.abilities.MageAbility;

public class Mage extends Unit{

    public Mage()
    {
        super("Mage", new MageAbility(), 100);
    }
}
