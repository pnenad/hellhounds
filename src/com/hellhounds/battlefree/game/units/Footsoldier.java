package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.FootsoldierAbility;
import com.hellhounds.battlefree.game.Player;

public class Footsoldier extends Unit{

    public Footsoldier(Player owner)
    {
        super("Footsoldier", new FootsoldierAbility(), 100, owner);
    }
    
}
