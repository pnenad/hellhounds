package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.ArcherAbility;

// Class for Archer unit

public class Archer extends Unit {

	public Archer ()
	{
		super ("Archer", new ArcherAbility(), 100);	
	}

}
