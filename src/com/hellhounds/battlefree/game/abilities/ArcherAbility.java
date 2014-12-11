package com.hellhounds.battlefree.game.abilities;
// This attack may hit two targets for 20 damage each

import com.hellhounds.battlefree.game.effects.DamageEffect;

public class ArcherAbility extends Ability{

	public ArcherAbility()
	{
		super("Double Shot", new Payment(1, 1, 0, 0), 
              new DamageEffect(20, false, false),
              new DamageEffect(20, false, false));
	}
	
}
