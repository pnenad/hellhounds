package com.hellhounds.battlefree.game.abilities.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class NoneEffect extends Effect{

    public NoneEffect(int value)
    {
        super(EffectType.NONE, value);
    }

    @Override
    public void applyEffect(Unit source)
    {
        System.out.println("U fkin wot m8");
    }
}
