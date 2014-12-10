package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.*;

public class SkeletonAbility extends Ability{

    public SkeletonAbility()
    {
        super("Bone Dagger", new Payment(0, 0, 1, 1), new PierceEffect(10), new PierceEffect(10));
    }
}
