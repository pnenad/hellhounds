package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.abilities.effects.*;

public class VampireAbility extends Ability{

    public VampireAbility()
    {
        super("Blood Drink", new Payment(1, 0, 1, 1),
                new DamageEffect(25), new HealEffect(15));
    }
}
