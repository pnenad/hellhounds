package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.BarbarianAbility;
import com.hellhounds.battlefree.game.Player;

public class Barbarian extends Unit{

	public Barbarian(Player owner)
	{
		super("Barbarian", new BarbarianAbility(), 100, owner);
	}
	
}
