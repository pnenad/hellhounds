package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.abilities.effects.*;

public class MageAbility extends Ability{

    public MageAbility()
    {
        super("Yin & Yang", new Payment(0, 0, 2, 1),
                new PierceEffect(20), new HealEffect(10));
    }
}
