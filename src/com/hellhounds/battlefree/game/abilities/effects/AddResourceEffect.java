package com.hellhounds.battlefree.game.abilities.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class AddResourceEffect extends Effect{

    public AddResourceEffect(int value)
    {
        super(EffectType.ADD, value);
    }

    @Override
    public void applyEffect(Unit source)
    {
        source.getOwner().generateResource(getNumericalValue());
    }
}
