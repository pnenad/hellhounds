package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.units.Unit;

public abstract class Effect{

    private int numericalValue = 0;
    private String type;
    private Unit[] targets;
    private int index = 0;

    public Effect(String type, int value)
    {
        this.numericalValue = value;
        this.type = type;
        this.targets = new Unit[0];
    }

    public void addTarget(Unit target)
    {
        Unit[] temp = new Unit[++index];

        for(int i = 0; i < targets.length; i++)
            temp[i] = targets[i];

        temp[index -1] = target;

        targets = temp;
    }

    @Override
    public String toString()
    {
        return "\n\t\t\tType: " + type +
               "\n\t\t\tValue: " + numericalValue;
    }

    public int getNumericalValue(){ return numericalValue; }

    public String getType(){ return type; }

    public Unit[] getTargets(){ return this.targets; }


    /* ------------ ABSTRACT --------------------*/

    public abstract void applyEffect(Unit source);
}
