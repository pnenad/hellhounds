package com.hellhounds.battlefree.game.units;


import com.hellhounds.battlefree.game.abilities.MushroomAbility;

public class Mushroom extends Unit{

    public Mushroom()
    {
        super("Mushroom", new MushroomAbility(), 100);
    }
}
