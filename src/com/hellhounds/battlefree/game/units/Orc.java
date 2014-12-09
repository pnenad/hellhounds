package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.OrcAbility;

public class Orc extends Unit{

    public Orc()
    {
        super("Orc", new OrcAbility(), 100);
    }
}
