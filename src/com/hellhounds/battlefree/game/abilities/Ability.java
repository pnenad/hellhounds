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

import com.hellhounds.battlefree.game.effects.Effect;

public class Ability{

    private String name;
    private Payment cost;
    private boolean activated;
    private Effect primary;
    private Effect secondary;

    public Ability(String name, Payment cost, Effect primary, Effect secondary)
    {
        this.name = name;
        this.cost = cost;
        this.activated = false;
        this.primary = primary;
        this.secondary = secondary;
    }
   
    public boolean checkSpecificPayment(Payment po)
    {
        return this.cost.getGold() == po.getGold() &&
               this.cost.getSteel() == po.getSteel() &&
               this.cost.getCrystal() == po.getCrystal();
    }

    public boolean checkAnyPayment(Payment ap)
    {
        int sumCost = this.cost.getGold() + this.cost.getSteel() +
                      this.cost.getCrystal() + this.cost.getAny();

        int sumPay = ap.getGold() + ap.getSteel() + ap.getCrystal();
        
        return sumCost == sumPay;
    }

    public Effect getPrimary(){ return primary; }
    public void setPrimary(Effect primary){ this.primary = primary; }

    public Effect getSecondary(){ return secondary; }
    public void setSecondary(Effect secondary){ this.secondary = secondary; }

     public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public Payment getCost(){ return this.cost; }
    public void setCost(Payment cost){ this.cost = cost; }

    public boolean isActivated(){ return this.activated; }
    public void setActivated(boolean activated){ this.activated = activated; }
}
