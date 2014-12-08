package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.ThiefAbility;

public class Thief extends Unit{

    public Thief()
    {
        super("Thief", new ThiefAbility(), 100);
    }
}
