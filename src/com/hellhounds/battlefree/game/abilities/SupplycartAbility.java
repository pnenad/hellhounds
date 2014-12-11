package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.*;

public class SupplycartAbility extends Ability{

    public SupplycartAbility()
    {
        super("Reinforcements", new Payment(0, 0, 0, 2),
                new AddResourceEffect(1, true, false), new DamageEffect(10, false, false));
    }
}
