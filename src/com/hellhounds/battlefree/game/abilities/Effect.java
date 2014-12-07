package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public abstract class Effect{

    private int numericalValue = 0;
    private String type;

    public Effect(String type, int value)
    {
        this.numericalValue = value;
        this.type = type;
    }

    public abstract void applyEffect(Unit[] targets);

    @Override
    public String toString()
    {
        return "\n\t\t\tType: " + type +
               "\n\t\t\tValue: " + numericalValue;
    }

    public int getNumericalValue(){ return numericalValue; }

    public String getType(){ return type; }
}
