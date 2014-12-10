package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.DamageEffect;
import com.hellhounds.battlefree.game.effects.StealResourceEffect;

public class ThiefAbility extends Ability{

    public ThiefAbility()
    {
        super("Mug", new Payment(1, 0, 1, 0),
              new StealResourceEffect(1), new DamageEffect(15));
    }
}
