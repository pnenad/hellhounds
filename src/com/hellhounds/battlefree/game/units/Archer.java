package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.ArcherAttack;

public class Archer extends Unit {

	public Archer ()
	{
		super ("Archer", new ArcherAttack());	
	}

}