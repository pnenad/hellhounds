package com.hellhounds.battlefree.game.units;
import com.hellhounds.battlefree.game.abilities.DefenderShield;

public class Defender extends Unit{

	public Defender()
	{
		super("Defender", new DefenderShield(), 100);
	}
	
}
