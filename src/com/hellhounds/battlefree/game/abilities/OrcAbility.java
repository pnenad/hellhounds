package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.*;

public class OrcAbility extends Ability{

    public OrcAbility()
    {
        super("Double Crush", new Payment(1, 1, 0, 0),
                new CrushEffect(12, false, false), new CrushEffect(12, false, false));
    }
}
