package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.abilities.effects.*;

public class OrcAbility extends Ability{

    public OrcAbility()
    {
        super("Double Crush", new Payment(1, 1, 0, 0), new CrushEffect(15), new CrushEffect(15));
    }
}
