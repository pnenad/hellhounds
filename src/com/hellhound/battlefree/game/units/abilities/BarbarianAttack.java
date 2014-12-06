package com.hellhound.battlefree.game.units.abilities;
// This attack should hit all enemies if possible.
// (Whirlwind)
public class BarbarianAttack extends Ability{

	public BarbarianAttack()
	{
		super("BarbarianAttack", new Payment (2, 0, 0, 0), 
			AbilityType.DAMAGE, 20);
	}
	
}