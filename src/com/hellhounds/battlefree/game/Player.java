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
package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.abilities.ResourceType;
import com.hellhounds.battlefree.game.units.Unit;

import java.util.HashMap;
import java.util.Random;

public class Player{

    private String username;
    private boolean loss;
    private Unit[] units = new Unit[3];
    private int gold, steel, crystal;
    private HashMap<String, Unit> unitMap;

    public Player(String username, Unit unit1, Unit unit2, Unit unit3)
    {
        this.username = username;
        this.loss = false;
        units[0] = unit1;
        units[1] = unit2;
        units[2] = unit3;
        unitMap = new HashMap<>();
        initUnits();
        generateResource();
    }

    private void initUnits()
    {
        for(Unit unit : getUnits())
        {
            unit.setOwner(this);
            unitMap.put(unit.getName(), unit);
        }
    }

    public void generateResource()
    {
        for(Unit unit : getUnits())
            if(unit.isAlive())
                generateResource(1);
    }

    public void generateResource(int times)
    {
        for(int i = 0; i < times; i++)
        {
            switch(new Random().nextInt(3))
            {
                case 0:
                    this.gold++;
                    System.out.format("%s got one GOLD resource\n", this.username);
                    break;

                case 1:
                    this.steel++;
                    System.out.format("%s got one STEEL resource\n", this.username);
                    break;

                case 2:
                    this.crystal++;
                    System.out.format("%s got one CRYSTAL resource\n", this.username);
                    break;
            }
        }
    }

    public void addResource(ResourceType type, int amount)
    {
        switch(type)
        {
            case GOLD:
                this.gold = this.gold + amount;
                break;

            case STEEL:
                this.steel = this.steel + amount;
                break;

            case CRYSTAL:
                this.crystal = this.crystal + amount;
                break;
        }
    }

    public int removeResource(ResourceType type, int amount)
    {
        switch(type)
        {
            case GOLD:
                if(this.gold > 0 && this.gold >= amount)
                {
                    this.gold = this.gold - amount;
                    return amount;
                } break;

            case STEEL:
                if(this.steel > 0 && this.steel >= amount)
                {
                    this.steel = this.steel - amount;
                    return amount;
                } break;

             case CRYSTAL:
                if(this.crystal > 0 && this.crystal >= amount)
                {
                    this.crystal = this.crystal - amount;
                    return amount;
                } break;
           }
        return 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        Player unknown;
        if(obj instanceof Player)
            unknown = (Player) obj;
        else return false;

        if(unknown.getUsername().equalsIgnoreCase(this.getUsername()))
            return true;
        else return false;
    }

    @Override
    public String toString()
    {
        return "Username: " + username +
                "\nPlayer Resource: " +
                "\n\t\tGold: " + gold +
                "\n\t\tSteel: " + steel +
                "\n\t\tCrystal: " + crystal +
                "\n\nUnit1 --> " + units[0].toString() +
                "\n\nUnit2 --> " + units[1].toString() +
                "\n\nUnit3 --> " + units[2].toString();
    }

    public Unit[] getUnits(){ return this.units; }

    public Unit getUnit(String unitName)
    {
        Unit unit = unitMap.get(unitName);
        if(unit != null) return unit;
        else throw new NullPointerException("No such hero " +  unitName);
    }

    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }

    public int getGold() { return gold; }
    public void setGold(int gold){ this.gold = gold; }

    public int getSteel() { return steel; }
    public void setSteel(int steel){ this.steel = steel; }

    public int getCrystal() { return crystal; }
    public void setCrystal(int crystal){ this.crystal = crystal; }

    public boolean getLoss(){ return loss; }
    public void setLoss(boolean loss){ this.loss = loss; }
}
