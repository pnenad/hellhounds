package com.hellhound.battlefree.game.units.abilities;

// The most basic attack, for the most basic
// unit in the game.

public class FootsoldierAttack extends Ability{

    public FootsoldierAttack()
    {
        super("FootsoldierAttack", new Payment(0, 0, 0, 1), 
              AbilityType.DAMAGE, 15);
    }

}
