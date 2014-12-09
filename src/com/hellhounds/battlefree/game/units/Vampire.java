package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.VampireAbility;

public class Vampire extends Unit{

    public Vampire()
    {
        super("Vampire", new VampireAbility(), 100);
    }
}
