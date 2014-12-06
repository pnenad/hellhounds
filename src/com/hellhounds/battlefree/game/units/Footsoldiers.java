package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.FootsoldierAttack;

public class Footsoldiers extends Unit{

    public Footsoldiers()
    {
        super("Footsoldiers", new FootsoldierAttack(), 100);
    }
    
}
