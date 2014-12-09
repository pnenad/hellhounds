package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.DwarfAbility;

public class Dwarf extends Unit{

	public Dwarf()
	{
		super("Dwarf", new DwarfAbility(), 100);
	}
	
}
