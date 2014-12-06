package com.hellhounds.battlefree.game.abilities;
// To make this attack more interesting, it should hit 
// the same target twice for 20 hp. This would make
// it weaker against armored foes.
public class ArcherAttack extends Ability{

	public ArcherAttack()
	{
		super("ArcherAttack", new Payment(1, 1, 0, 0),
			AbilityType.DAMAGE, 40);
	}
	
}