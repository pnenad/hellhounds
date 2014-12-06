package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class DamageEffect extends Effect{

    public DamageEffect(int value)
    {
        super("DAMAGE", value);
    }
    
    @Override
    public void applyEffect(Unit[] targets)
    {
        for(Unit target : targets)
        {
            int damage = getNumericalValue();
            int armor = target.getArmor();
            int health = target.getHealth();

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
                    target.setHealth(health - rest);
                }
            }
            else
            {
                target.setHealth(health - damage);
            }
        }
    }
}
