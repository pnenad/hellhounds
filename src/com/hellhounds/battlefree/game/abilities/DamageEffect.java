package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class DamageEffect extends Effect{

    public DamageEffect(int value)
    {
        super("DAMAGE", value);
    }
    
    @Override
    public void applyEffect()
    {
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            int damage = getNumericalValue();
            int armor = target.getArmor();
            int health = target.getCurrentHealth();

            if(armor > 0 )
            {
                int rest  = damage - armor;

                if(rest <= 0 )
                {
                    target.setArmor(-rest);
                    continue;
                }
                else
                {
                    target.setCurrentHealth(health - rest);
                    target.setArmor(0);
                }
            }
            else
            {
                target.setCurrentHealth(health - damage);
            }
            
            System.out.println(" attacked " + target.getName() + " for " + damage);
        }
    }
}
