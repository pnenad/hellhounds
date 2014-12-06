package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public class Effect{

    private int numericalValue = 0;
    private String type;

    public Effect(String type, int value)
    {
        this.numericalValue = value;
        this.type = type;
    }

    public void applyEffect(Unit[] targets)
    {
        for(Unit target : targets)
        {
            System.out.println("EFFECT SUPER: " + target.getName());
        }
    }

    @Override
    public String toString()
    {
        return "\n\t\t\tType: " + type +
               "\n\t\t\tValue: " + numericalValue;
    }

    public int getNumericalValue(){ return numericalValue; }

    public String getType(){ return type; }
}
