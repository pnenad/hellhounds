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

        System.out.println("Player One:\n" + game.getPlayer1().toString());
        System.out.println("\nPlayer Two:\n" + game.getPlayer2().toString());

    }
}
