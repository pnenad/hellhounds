package com.hellhounds.battlefree.game.units;

import com.hellhounds.battlefree.game.abilities.SkeletonAbility;

public class Skeleton extends Unit{

    public Skeleton()
    {
        super("Skeleton", new SkeletonAbility(), 100);
    }
}
