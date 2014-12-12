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

public class DamageEffect extends Effect{

    public DamageEffect(int value, boolean friendly, boolean multiple)
    {
        super(EffectType.DAMAGE, value, friendly, multiple);
    }
    
    @Override
    public void applyEffect(Unit source)
    {
        Unit[] targets = getTargets();

        for(Unit target : targets)
        {
            int rawDamage = getNumericalValue();
            int armor = target.getArmor();
            int health = target.getCurrentHealth();

            int calcDamage = rawDamage - armor;
            health  = health - calcDamage;

            if(calcDamage < 0)
            {
                armor = -calcDamage;
                calcDamage = 0;
            }


            
            target.setCurrentHealth(health);

            System.out.format("%s's %s attacked %s's %s for %d%s\n", 
                              source.getOwner().getUsername(),
                              source.getName(),
                              target.getOwner().getUsername(),
                              target.getName(),
                              calcDamage,
                              (armor > 0) ? " (" + armor + " blocked by armor)" :  "");
        }
    }
}
