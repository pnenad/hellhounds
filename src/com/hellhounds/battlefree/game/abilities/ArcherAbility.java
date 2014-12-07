package com.hellhounds.battlefree.game.abilities;
// To make this attack more interesting, it should hit 
// the same target twice for 20 hp. This would make
// it weaker against armored foes.
public class ArcherAbility extends Ability{

	public ArcherAbility()
	{
		super("Double Shot", new Payment(1, 1, 0, 0), 
              new DamageEffect(20),
              new DamageEffect(20));
	}
	
}
