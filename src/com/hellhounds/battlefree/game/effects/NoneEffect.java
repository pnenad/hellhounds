package com.hellhounds.battlefree.game.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class NoneEffect extends Effect{

    public NoneEffect()
    {
        super(EffectType.NONE, 0, true, false);
    }

    @Override
    public void applyEffect(Unit source)
    {
        System.out.println("U fkin wot m8");
    }
}
