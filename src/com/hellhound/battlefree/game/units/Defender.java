package com.hellhounds.battlefree.game.units;
import com.hellhounds.battlefree.game.units.abilities.DefenderShield;

public class Defender extends Unit{

	public Defender()
	{
		super("Defender", new DefenderShield());
	}
	
}