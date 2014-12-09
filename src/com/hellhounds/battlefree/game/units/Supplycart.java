package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.SupplycartAbility;

public class Supplycart extends Unit {

    public Supplycart()
    {
        super("Supplycart", new SupplycartAbility(), 100);
    }
}
