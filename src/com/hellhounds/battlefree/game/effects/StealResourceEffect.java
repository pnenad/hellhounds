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
import java.util.ArrayList;
import java.util.Random;

public class StealResourceEffect extends Effect{

    private ArrayList<String> resourceList;
    
    public StealResourceEffect(int value, boolean friendly, boolean multiple)
    {
        super(EffectType.STEAL, value, friendly, multiple);
        resourceList = new ArrayList<String>();
        resourceList.add("STEEL");
        resourceList.add("GOLD");
        resourceList.add("CRYSTAL");
    }

    @Override
    public void applyEffect(Unit source)
    {
        Random rand = new Random();
        Unit[] targets = getTargets();
        int index = rand.nextInt(resourceList.size());
        String resource = resourceList.get(index);

        if(resourceList.size() > 0)
        {
            for(Unit target : targets)
            {
                int stolenResource = target.getOwner().removeResource(resource,
                                     getNumericalValue());
                
                if(stolenResource > 0)
                {
                    source.getOwner().addResource(resource, stolenResource);

                    System.out.format("%s's %s stole %d %s from %s\n",
                                      source.getOwner().getUsername(),
                                      source.getName(),
                                      stolenResource,
                                      resource,
                                      target.getOwner().getUsername());
                    break;
                }
                else
                {
                    resourceList.remove(index);
                    applyEffect(source);
                }
            }
        }
    }
}


