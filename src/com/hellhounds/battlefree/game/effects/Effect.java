package com.hellhounds.battlefree.game.effects;

import com.hellhounds.battlefree.game.units.Unit;

public abstract class Effect{

    private int numericalValue = 0;
    private EffectType type;
    private boolean friendly;
    private boolean multipleTargets;
    private Unit[] targets;
    private int index = 0;

    public Effect(EffectType type, int value, boolean friendly, boolean multipleTargets)
    {
        this.numericalValue = value;
        this.type = type;
        this.friendly = friendly;
        this.multipleTargets = multipleTargets;
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

    public void removeTargets()
    {
        targets = new Unit[0];
        index = 0;
    }

    @Override
    public String toString()
    {
        return "\n\t\t\tType: " + type +
               "\n\t\t\tValue: " + numericalValue;
    }

    public int getNumericalValue(){ return numericalValue; }

    public EffectType getType(){ return type; }

    public Unit[] getTargets(){ return this.targets; }
    public void setTargets(Unit[] units){ this.targets = units; }

    public boolean isFriendly() {
        return friendly;
    }

    public boolean isMultipleTargets() {
        return multipleTargets;
    }

    /* ------------ ABSTRACT --------------------*/

    public abstract void applyEffect(com.hellhounds.battlefree.game.units.Unit source);
}
