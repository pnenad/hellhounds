package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.CatapultAbility;
import com.hellhounds.battlefree.game.Player;

public class Catapult extends Unit{
	
	public Catapult(Player owner)
	{
		super("Catapult", new CatapultAbility(), 100, owner);
	}

}	
	
