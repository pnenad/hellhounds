package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.Ability;

public class Unit{

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
    
    @Override
    public String toString()
    {
        return getName() +
               "\n\t  Alive: " + alive +
               "\n\t  Max Health: " + maxHealth +
               "\n\t  Current Health: " + currentHealth +
               "\n\t  Armor: " + armor +
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
}
