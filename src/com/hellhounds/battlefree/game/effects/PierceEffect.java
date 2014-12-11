package com.hellhounds.battlefree.game.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class PierceEffect extends Effect{

    public PierceEffect(int value)
    {
        super(EffectType.PIERCE, value);
    }

    @Override
    public void applyEffect(Unit source)
    {
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            int damage = getNumericalValue();
            int health = target.getCurrentHealth();

            target.setCurrentHealth(health - damage);

            System.out.format("%s's %s pierced %s's %s for %d\n",
                    source.getOwner().getUsername(),
                    source.getName(),
                    target.getOwner().getUsername(),
                    target.getName(),
                    damage);
        }
    }
}
