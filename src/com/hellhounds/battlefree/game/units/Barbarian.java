package com.hellhounds.battlefree.game.units;
import com.hellhounds.battlefree.game.abilities.BarbarianAttack;

public class Barbarian extends Unit{

	public Barbarian()
	{
		super("Barbarian", new BarbarianAttack());
	}
	
}