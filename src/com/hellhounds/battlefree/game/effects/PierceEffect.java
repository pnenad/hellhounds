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
package com.hellhounds.battlefree.game.effects;

import com.hellhounds.battlefree.game.units.Unit;

public class PierceEffect extends Effect{

    public PierceEffect(int value, boolean friendly, boolean multiple)
    {
        super(EffectType.PIERCE, value, friendly, multiple);
    }

    @Override
    public void applyEffect(Unit source)
    {
        for(Unit target : getTargets())
        {
            int damage = getNumericalValue();
            int health = target.getCurrentHealth();

            target.setCurrentHealth(health - damage);

            System.out.format("%s's %s pierced %s's %s for %d\n",
                    source.getOwner().getUsername(),
                    source.getName(),
                    target.getOwner().getUsername(),
                    target.getName(),
                    damage);
        }
    }
}
