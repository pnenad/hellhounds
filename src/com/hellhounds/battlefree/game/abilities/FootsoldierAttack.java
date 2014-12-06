package com.hellhounds.battlefree.game.abilities;

// The most basic attack, for the most basic
// unit in the game.

public class FootsoldierAttack extends Ability{

    public FootsoldierAttack()
    {
        super("FootsoldierAttack", new Payment(0, 0, 0, 1), 
              new DamageEffect(10),
              new DamageEffect(0));
    }

}
