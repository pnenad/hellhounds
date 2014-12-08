package com.hellhounds.battlefree.game.abilities;

public class AddResourceEffect extends Effect{

    public AddResourceEffect(int value)
    {
        super("ADDRESOURCE", value);
    }

    @Override
    public void applyEffect(Unit source)
    {
        source.getOwner().generateResource(getNumericalValue());
    }
}
