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
package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.Ability;
import com.hellhounds.battlefree.game.Player;

public class Unit{

    private Player owner;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private Ability ability;
    private boolean alive;
    private int armor;

    public Unit(String name, Ability ability, int health)
    {
        this.name = name;
        this.ability = ability;
        this.alive = true;
        this.currentHealth = health;
        this.maxHealth  = health;
        this.armor = 0;
    }

    public void addPrimaryTarget(Unit target)
    {
        ability.getPrimary().addTarget(target);
    }

    public void addSecondaryTarget(Unit target)
    {
        ability.getSecondary().addTarget(target);
    }
    
    @Override
    public String toString()
    {
        return getName() +
               "\n\t  Alive: " + alive +
               "\n\t  Current Health: " + currentHealth + "/" + maxHealth +
               "\n\t  Ability: " + ability.getName() +
               "\n\t  PrimaryEffect: " + ability.getPrimary().toString() +
               "\n\t  SecondaryEffect: " + ability.getSecondary().toString() +
               "\n" + ability.getCost().toString();
    }
 
    public int getArmor(){ return this.armor; }
    public void setArmor(int armor){ this.armor = armor; }

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public Ability getAbility(){ return this.ability; }
    public void setAbility(Ability ability){ this.ability = ability; }

    public boolean isAlive(){ return alive; }
    public void setAlive(boolean alive){ this.alive = alive; }

    public int getMaxHealth(){ return maxHealth; }
    public void setMaxHealth(int maxHealth){ this.maxHealth = maxHealth; }

    public int getCurrentHealth(){ return currentHealth; }
    public void setCurrentHealth(int currentHealth){ this.currentHealth = currentHealth; }

    public Player getOwner(){ return owner; }
    public void setOwner(Player owner){ this.owner = owner; }
}
