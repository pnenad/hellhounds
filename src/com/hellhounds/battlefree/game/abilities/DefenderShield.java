package com.hellhounds.battlefree.game.abilities;

// This ability should deal 10 damage to one target
// enemy, and grant each teammate 10 temporary
// armor/shield.

public class DefenderShield extends Ability{
	
	public DefenderShield()
	{
		super("DefenderShield", new Payment(0, 1, 0, 1),
			  new DamageEffect(10),
              new ArmorEffect(10));
	}
	
}
