package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.units.*;

public class GameInit{

    public static void main(String[] args)
    {
        PlayerBuilder pb = new PlayerBuilder("Mannebind");
        Player p1 = pb.unit1(new Footsoldier()).unit2(new Archer()).
                    unit3(new Defender()).gold(1).steel(2).crystal(3).
                    create();

        pb = new PlayerBuilder("iEzpeN");
        Player p2 = pb.unit1(new Barbarian()).unit2(new Footsoldier()).
                    unit3(new Catapult()).gold(3).steel(2).crystal(1).
                    create();

        Game game = new Game(p1, p2, 1);

        game.setRoundNr(1);
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

        game.resolveEffect("ARMOR");
        game.resolveEffect("DAMAGE");
        game.resolveEffect("HEAL");

        System.out.println("Player One:\n" + game.getPlayer1().toString());
        System.out.println("\nPlayer Two:\n" + game.getPlayer2().toString());

    }
}
