package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.*;

public class VampireAbility extends Ability{

    public VampireAbility()
    {
        super("Drink Blood", new Payment(1, 0, 1, 1),
                new DamageEffect(25, false, false), new HealEffect(15, true, false));
    }
}
