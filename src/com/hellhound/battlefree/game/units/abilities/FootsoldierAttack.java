package com.hellhound.battlefree.game.units.abilities;

public class FootsoldierAttack extends Ability{

    public FootsoldierAttack()
    {
        super("FootsoldierAttack", new Payment(0, 0, 0, 1), 
              AbilityType.DAMAGE, 15);
    }

}
