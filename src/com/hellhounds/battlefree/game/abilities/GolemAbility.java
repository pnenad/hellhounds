package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.CrushEffect;
import com.hellhounds.battlefree.game.effects.DamageEffect;

public class GolemAbility extends Ability {

    public GolemAbility() {
        super("Golem Smash", new Payment(0, 1, 1, 0),
                new CrushEffect(20) , new DamageEffect(10));
    }
}
