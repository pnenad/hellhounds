package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.abilities.EffectType;
import com.hellhounds.battlefree.game.units.*;

public class GameInit{

    public static void main(String[] args)
    {
        
        Player p1 = new Player("Mannebind", new Footsoldier(), new Archer(),
                               new Defender());

        Player p2 = new Player("iEzpeN", new Barbarian(), new Thief(),
                               new Catapult());

        Game game = new Game(p1, p2, 1);

        p1.getUnit1().getAbility().setActivated(true);
        p1.getUnit1().getAbility().getPrimary().addTarget(p2.getUnit1());
        p1.getUnit1().getAbility().getSecondary().addTarget(p2.getUnit1());

        p1.getUnit3().getAbility().setActivated(true);
        p1.getUnit3().getAbility().getPrimary().addTarget(p2.getUnit1());
        p1.getUnit3().getAbility().getSecondary().addTarget(p1.getUnit1());
        p1.getUnit3().getAbility().getSecondary().addTarget(p1.getUnit2());
        p1.getUnit3().getAbility().getSecondary().addTarget(p1.getUnit3());

        p2.getUnit3().getAbility().setActivated(true);
        p2.getUnit3().getAbility().getPrimary().addTarget(p1.getUnit2());
        p2.getUnit3().getAbility().getSecondary().addTarget(p1.getUnit1());
        
        p2.getUnit2().getAbility().setActivated(true);
        p2.getUnit2().getAbility().getPrimary().addTarget(p1.getUnit3());
        p2.getUnit2().getAbility().getSecondary().addTarget(p1.getUnit3());

        System.out.println("-------------------- COMBAT LOG --------------------------\n");
        game.resolveEffect(EffectType.ARMOR);
        game.resolveEffect(EffectType.CRUSH);
        game.resolveEffect(EffectType.DAMAGE);
        game.resolveEffect(EffectType.PIERCE);
        game.resolveEffect(EffectType.HEAL);
        game.resolveEffect(EffectType.ADD);
        game.resolveEffect(EffectType.STEAL);
        game.cleanup();
        System.out.println();

        System.out.println("---------------------   STATS   --------------------------\n");
        System.out.println("Player One:\n" + game.getPlayer1().toString());
        System.out.println("\nPlayer Two:\n" + game.getPlayer2().toString());

    }
}
