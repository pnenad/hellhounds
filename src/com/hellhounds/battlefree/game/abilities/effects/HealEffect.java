package com.hellhounds.battlefree.game.abilities.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class HealEffect extends Effect{

    public HealEffect(int value)
    {
        super(EffectType.HEAL, value);
    }

    @Override
    public void applyEffect(Unit source)
    {
        int heal = getNumericalValue();
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            target.setCurrentHealth(target.getCurrentHealth() + heal);
            System.out.format("%s's %s healed  %s's %s for %d\n", 
                              source.getOwner().getUsername(),
                              source.getName(),
                              target.getOwner().getUsername(),
                              target.getName(),
                              heal);
        }
    }
}
