package com.hellhoundss.battlefree.game.units;
import com.hellhoundss.battlefree.game.units.abilities.CatapultAttack;

public class Catapult extends Unit{
	
	public Catapult()
	{
		super("Catapult", new CatapultAttack());
	}

}	
	