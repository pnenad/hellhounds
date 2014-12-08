package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class DamageEffect extends Effect{

    public DamageEffect(int value)
    {
        super("DAMAGE", value);
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
            
            target.setCurrentHealth(health);

            System.out.format("%s's %s attacked %s's %s for %d%s\n", 
                              source.getOwner().getUsername(),
                              source.getName(),
                              target.getOwner().getUsername(),
                              target.getName(),
                              calcDamage, 
                              (armor > 0) ? " (" + armor + " blocked by armor)" :  "");
        }
    }
}
