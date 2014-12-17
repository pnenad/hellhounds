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
import java.util.HashMap;
import java.util.Iterator;

public abstract class Effect{

    private int numericalValue = 0;
    private EffectType type;
    private boolean friendly, multipleTargets;
    private HashMap<String, Unit> targets;

    public Effect(EffectType type, int value, boolean friendly, boolean multipleTargets)
    {
        this.numericalValue = value;
        this.type = type;
        this.friendly = friendly;
        this.multipleTargets = multipleTargets;
        targets = new HashMap<>();
    }

    public void addTarget(Unit target)
    {
        if(!targets.containsKey(target))
            targets.put(target.getName(), target);
    }

    public void removeTargets()
    {
        targets.clear();
    }

    @Override
    public String toString()
    {
        return "\n\t\t\tType: " + type +
               "\n\t\t\tValue: " + numericalValue;
    }

    // ----------------- ABSTRACT --------------------

    public abstract void applyEffect(Unit source);

    // ----------------- GET & SET --------------------

    /**
     * Retrive all units target by this effect
     * @return an array of targeted units
     */
    public Unit[] getTargets(){
        Iterator<String> it = targets.keySet().iterator();
        Unit[] targetsArray = new Unit[targets.keySet().size()];

        for(int i = 0; it.hasNext(); i++)
            targetsArray[i] = targets.get(it.next());

        return targetsArray;
    }
    
    public int getNumericalValue(){ return numericalValue; }
    public EffectType getType(){ return type; }
    public boolean isFriendly(){ return friendly; }
    public boolean isMultipleTargets(){ return multipleTargets; }


}
