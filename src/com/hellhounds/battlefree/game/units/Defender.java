package com.hellhoundss.battlefree.game.units;
import com.hellhoundss.battlefree.game.units.abilities.DefenderShield;

public class Defender extends Unit{

	public Defender()
	{
		super("Defender", new DefenderShield());
	}
	
}