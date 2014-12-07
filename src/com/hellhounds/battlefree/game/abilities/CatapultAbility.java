package com.hellhounds.battlefree.game.abilities;

// The catapult has poor aim but hits hard.
// As such it will hit a random (living) enemy unit.

public class CatapultAbility extends Ability{

	public CatapultAbility()
	{
		super("Stone Rain", new Payment(1, 1, 0, 1),
              new DamageEffect(30),
              new DamageEffect(30));
	}
	
}
