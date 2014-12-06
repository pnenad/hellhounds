package com.hellhound.battlefree.game.units;
import com.hellhound.battlefree.game.units.abilities.BarbarianAttack;

public class Barbarian extends Unit{

	public Barbarian()
	{
		super("Barbarian", new BarbarianAttack());
	}
	
}