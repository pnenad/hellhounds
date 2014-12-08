package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.FootsoldierAbility;

public class Footsoldier extends Unit{

    public Footsoldier()
    {
        super("Footsoldier", new FootsoldierAbility(), 100);
    }
    
}
