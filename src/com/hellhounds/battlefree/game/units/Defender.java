package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.DefenderAbility;

public class Defender extends Unit{

	public Defender()
	{
		super("Defender", new DefenderAbility(), 100);
	}
	
}
