package com.hellhounds.battlefree.game.abilities;

// The most basic attack, for the most basic
// unit in the game.

import com.hellhounds.battlefree.game.abilities.effects.DamageEffect;
import com.hellhounds.battlefree.game.abilities.effects.NoneEffect;

public class FootsoldierAbility extends Ability{

    public FootsoldierAbility()
    {
        super("Rank and File", new Payment(0, 0, 0, 1), 
              new DamageEffect(10),
              new NoneEffect(0));
    }

}
