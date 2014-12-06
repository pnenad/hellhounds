package com.hellhounds.battlefree.game.units;
import com.hellhounds.battlefree.game.units.abilities.CatapultAttack;

public class Catapult extends Unit{
	
	public Catapult()
	{
		super("Catapult", new CatapultAttack());
	}

}	
	