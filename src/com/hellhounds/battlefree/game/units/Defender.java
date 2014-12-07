package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.DefenderAbility;
import com.hellhounds.battlefree.game.Player;

public class Defender extends Unit{

	public Defender(Player owner)
	{
		super("Defender", new DefenderAbility(), 100, owner);
	}
	
}
