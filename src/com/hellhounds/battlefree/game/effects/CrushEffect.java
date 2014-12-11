package com.hellhounds.battlefree.game.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class CrushEffect extends Effect {

    public CrushEffect(int value, boolean friendly, boolean multiple)
    {
        super(EffectType.CRUSH, value, friendly, multiple);
    }

    @Override
    public void applyEffect(Unit source)
    {
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            int rawDamage = getNumericalValue();
            int armor = target.getArmor();
            int health = target.getCurrentHealth();

            int calcDamage = rawDamage - armor;
            health  = health - calcDamage;

            if(calcDamage >= 0)
            {
                target.setArmor(0);
                target.setCurrentHealth(health - calcDamage);
            }
            else
            {
                target.setArmor(-rawDamage);
            }

            target.setCurrentHealth(health);

            System.out.format("%s's %s crushed %s's %s for %d%s\n",
                    source.getOwner().getUsername(),
                    source.getName(),
                    target.getOwner().getUsername(),
                    target.getName(),
                    calcDamage,
                    (armor > 0) ? " (" + armor + " blocked by armor)" :  "");
        }
    }
}
