package com.hellhound.battlefree.game.units;

import com.hellhound.battlefree.game.units.abilities.FootsoldierAttack;

public class Footsoldiers extends Unit{

    public Footsoldiers()
    {
        super("Footsoldiers", new FootsoldierAttack());
    }
    
}
