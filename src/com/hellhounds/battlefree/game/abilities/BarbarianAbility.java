package com.hellhounds.battlefree.game.abilities;
// This attack should hit all enemies if possible.
// (Whirlwind)
public class BarbarianAbility extends Ability{

	public BarbarianAbility()
	{
		super("Whirlwind", new Payment (2, 0, 0, 0), 
              new DamageEffect(15),
              new DamageEffect(15));
	}
	
}
