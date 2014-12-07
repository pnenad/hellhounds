package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.ArcherAbility;
import com.hellhounds.battlefree.game.Player;

public class Archer extends Unit {

	public Archer (Player owner)
	{
		super ("Archer", new ArcherAbility(), 100, owner);	
	}

}
