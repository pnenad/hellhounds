package com.hellhounds.battlefree.game.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class ArmorEffect extends Effect{

    public ArmorEffect(int value)
    {
        super(EffectType.ARMOR, value);
    }

    @Override
    public void applyEffect(Unit source)
    {
        int addArmor = getNumericalValue();
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            int currentArmor = target.getArmor();
            target.setArmor(currentArmor + addArmor);
            System.out.format("%s's %s armored %s's %s for %d\n", 
                              source.getOwner().getUsername(),
                              source.getName(),
                              target.getOwner().getUsername(),
                              target.getName(),
                              addArmor);
        }
    }
}
