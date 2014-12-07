package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class HealEffect extends Effect{

    public HealEffect(int value)
    {
        super("HEAL", value);
    }

    @Override
    public void applyEffect()
    {
        int heal = this.numericalValue;
        int health = target.getHealth();
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            target.setHealth(health + heal);
            System.out.println(" healed " + target.getName() + " for " + heal);
        }
    }
}
