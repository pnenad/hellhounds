package com.hellhound.battlefree.game.units;

import com.hellhound.battlefree.game.units.abilities.Ability;

public class Unit{

    private String name;
    private int health;
    private Ability ability;
    private boolean alive;

    public Unit(String name, Ability ability)
    {
        this.name = name;
        this.ability = ability;
        alive = true;
        health = 100;
    }
    
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public int getHealth(){ return this.health; }
    public void setHealth(int health){ this.health = health; }

    public Ability getAbility(){ return this.ability; }
    public void setAbility(Ability ability){ this.ability = ability; }

    public boolean isAlive(){ return alive; }
    public void setAlive(boolean alive){ this.alive = alive; }

    @Override
    public String toString()
    {
        return "Name: " + getName() +
               "\nHealth: " + getHealth() +
               "\nAbility: " + ability.getName() +
               "\nAbilityType: " + ability.getAbilityType() +
               "\nAbilityValue: " + ability.getValue() +
               "\n" + ability.getCost().toString() +
               "\nIs Alive: " + isAlive();
    }
 
}
