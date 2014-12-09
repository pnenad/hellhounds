package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.GolemAbility;

public class Golem extends Unit {

    public Golem()
    {
        super("Golem", new GolemAbility(), 100);
    }
}
