package com.hellhounds.battlefree.game.abilities;

// The most basic attack, for the most basic
// unit in the game.

public class FootsoldierAttack extends Ability{

    public FootsoldierAttack()
    {
        super("FootsoldierAttack", new Payment(0, 0, 0, 1), 
              AbilityType.DAMAGE, 15);
    }

}
