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

public class Payment{
    
    private int gold;
    private int steel;
    private int crystal;
    private int any;

    public Payment()
    {
       this.gold = 0;
       this.steel = 0;
       this.crystal = 0;
       this.any = 0;
    }

    public Payment(int gold, int steel, int crystal, int any)
    {
        this.gold = gold;
        this.steel = steel;
        this.crystal = crystal;
        this.any = any;
    }

    public int getGold(){ return this.gold; }
    public void setGold(int gold){ this.gold = gold; }

    public int getSteel(){ return this.steel; }
    public void setSteel(int steel){ this.steel = steel; }

    public int getCrystal(){ return this.crystal; }
    public void setCrystal(int crystal){ this.crystal = crystal; }

    public int getAny(){ return this.any; }
    public void setAny(int any){ this.any = any; }

    @Override
    public String toString()
    {
        return "\t  AbilityCost: " +
               "\n\t\t      Gold: " + getGold() +
               "\n\t\t      Steel: " + getSteel() +
               "\n\t\t      Crystal: " + getCrystal() +
               "\n\t\t      Any: " + getAny();
    }
}
