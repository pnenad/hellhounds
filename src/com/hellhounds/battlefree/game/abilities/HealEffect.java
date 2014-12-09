package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class HealEffect extends Effect{

    public HealEffect(int value)
    {
        super("HEAL", value);
    }

    @Override
    public void applyEffect(Unit[] targets)
    {
        int heal = getNumericalValue();

        for(Unit target : targets)
        {
            target.setHealth(target.getHealth() + heal);
        }
    }
}
