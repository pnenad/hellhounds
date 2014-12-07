package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.Ability;

public class Unit{

    private String name;
    private int health;
    private Ability ability;
    private boolean alive;
    private int armor;

    public Unit(String name, Ability ability, int health)
    {
        this.name = name;
        this.ability = ability;
        this.alive = true;
        this.health = health;
        this.armor = 0;
    }
    
    @Override
    public String toString()
    {
        return getName() +
               "\n\t  Alive: " + isAlive() +
               "\n\t  Health: " + getHealth() +
               "\n\t  Armor: " + getArmor() +
               "\n\t  Ability: " + ability.getName() +
               "\n\t  PrimaryEffect: " + ability.getPrimary().toString() +
               "\n\t  SecondaryEffect: " + ability.getSecondary().toString() +
               "\n" + ability.getCost().toString();
    }
 
    public int getArmor(){ return armor; }
    public void setArmor(int armor){ this.armor = armor; }

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public int getHealth(){ return this.health; }
    public void setHealth(int health){ this.health = health; }

    public Ability getAbility(){ return this.ability; }
    public void setAbility(Ability ability){ this.ability = ability; }

    public boolean isAlive(){ return alive; }
    public void setAlive(boolean alive){ this.alive = alive; }
}
