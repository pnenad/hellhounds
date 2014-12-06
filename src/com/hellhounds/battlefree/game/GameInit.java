package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.units.Footsoldiers;

public class GameInit{

    public static void main(String[] args)
    {
        PlayerBuilder pb = new PlayerBuilder("Mannebind");
        Player p1 = pb.unit1(new Footsoldiers()).unit2(new Footsoldiers()).
                    unit3(new Footsoldiers()).gold(1).steel(2).crystal(3).
                    create();

        pb = new PlayerBuilder("iEzpeN");
        Player p2 = pb.unit1(new Footsoldiers()).unit2(new Footsoldiers()).
                    unit3(new Footsoldiers()).gold(3).steel(2).crystal(1).
                    create();

        Game game = new Game(p1, p2, 1);

        System.out.println("Player One:\n" + game.getPlayer1().toString());
        System.out.println("\nPlayer Two:\n" + game.getPlayer2().toString());

    }
}
