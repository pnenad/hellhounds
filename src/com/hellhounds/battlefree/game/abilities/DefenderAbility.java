package com.hellhounds.battlefree.game.abilities;

// This ability should deal 10 damage to one target
// enemy, and grant each teammate 10 temporary
// armor/shield.

import com.hellhounds.battlefree.game.effects.ArmorEffect;
import com.hellhounds.battlefree.game.effects.DamageEffect;

public class DefenderAbility extends Ability{
	
	public DefenderAbility()
	{
		super("Shield Bash", new Payment(0, 1, 0, 1),
				new ArmorEffect(5, true, true),
				new DamageEffect(10, false, false));
	}
	
}
