package com.hellhounds.battlefree.game.abilities;

// This ability should deal 10 damage to one target
// enemy, and grant each teammate 10 temporary
// armor/shield.

public class DefenderAbility extends Ability{
	
	public DefenderAbility()
	{
		super("Shield Bash", new Payment(0, 1, 0, 1),
			  new DamageEffect(10),
              new ArmorEffect(10));
	}
	
}
