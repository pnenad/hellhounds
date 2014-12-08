package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.BarbarianAbility;

public class Barbarian extends Unit{

	public Barbarian()
	{
		super("Barbarian", new BarbarianAbility(), 100);
	}
	
}
