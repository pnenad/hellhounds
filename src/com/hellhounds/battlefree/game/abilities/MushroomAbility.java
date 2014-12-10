package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.*;

public class MushroomAbility extends Ability{

    public MushroomAbility()
    {
        super("Spore Cloud", new Payment(0, 0, 1, 0),
                new DamageEffect(10), new HealEffect(5));
    }
}
