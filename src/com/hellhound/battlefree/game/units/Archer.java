package com.hellhound.battlefree.game.units;

import com.hellhound.battlefree.game.units.abilities.ArcherAttack;

public class Archer extends Unit {

	public Archer ()
	{
		super ("Archer", new ArcherAttack());	
	}

}