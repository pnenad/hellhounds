package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class ArmorEffect extends Effect{

    public ArmorEffect(int value)
    {
        super("ARMOR", value);
    }

    @Override
    public void applyEffect()
    {
        int addArmor = getNumericalValue();
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            int currentArmor = target.getArmor();
            target.setArmor(currentArmor + addArmor);
            System.out.println(" armored " + target.getName() + " for " + addArmor);
        }
    }
}
