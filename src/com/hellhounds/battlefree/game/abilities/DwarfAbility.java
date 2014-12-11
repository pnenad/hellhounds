package com.hellhounds.battlefree.game.abilities;

// This ability should deal 25 damage to one target
// enemy, and grant itself 5 temporary
// armor/shield.

import com.hellhounds.battlefree.game.effects.ArmorEffect;
import com.hellhounds.battlefree.game.effects.DamageEffect;

public class DwarfAbility extends Ability{
	
	public DwarfAbility()
	{
		super("Steel wall", new Payment(1, 1, 0, 0),
			  new DamageEffect(25, false, false),
              new ArmorEffect(5, true, false));
	}
	
}
