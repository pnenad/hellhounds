/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
