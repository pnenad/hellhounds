/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.effects.EffectType;
import com.hellhounds.battlefree.game.units.*;
import com.hellhounds.battlefree.messaging.*;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

/**
 * Simple demonstration of a game loop.
 * The game will loop through combat rounds until a player is
 * declared the winner, or a draw is declared.
 * The units will have the same targets round after round
 * in this primitive demo. The results of each round of combat
 * will be printed to screen. Unit and player statistics is
 * printed to screen when the game ends.
 */
public class GameInit{

        public static void main(String[] args)
        {
                System.out.println("Starting Resources:");

                Player p1 = new Player("Mannebind", new Mage(), new Archer(),
                        new Defender());

                Player p2 = new Player("iEzpeN", new Supplycart(), new Thief(),
                        new Catapult());

                Game game = new Game(p1, p2, 1);

                p1.getUnit("Mage").getAbility().setActivated(true);
                p1.getUnit("Mage").addPrimaryTarget(p2.getUnit("Catapult"));
                p1.getUnit("Mage").addSecondaryTarget(p1.getUnit("Mage"));
                p1.getUnit("Defender").getAbility().setActivated(true);
                p1.getUnit("Defender").addPrimaryTarget(p1.getUnit("Mage"));
                p1.getUnit("Defender").addPrimaryTarget(p1.getUnit("Defender"));

                p2.getUnit("Thief").getAbility().setActivated(true);
                p2.getUnit("Thief").addPrimaryTarget(p1.getUnit("Mage"));
                p2.getUnit("Thief").addPrimaryTarget(p1.getUnit("Defender"));


                // This resolves a round of combat in the order set down in
                // the game rules.
                System.out.println("COMBAT LOG:\n");
                game.resolveEffect(EffectType.ARMOR);
                game.resolveEffect(EffectType.CRUSH);
                game.resolveEffect(EffectType.DAMAGE);
                game.resolveEffect(EffectType.PIERCE);
                game.resolveEffect(EffectType.HEAL);
                game.resolveEffect(EffectType.ADD);
                game.resolveEffect(EffectType.STEAL);
                game.cleanup();
                System.out.println();

                /*System.out.println("---------------------   STATS   --------------------------\n");

                System.out.println("Player One:\n" + game.getPlayer1().toString());
                System.out.println("\nPlayer Two:\n" + game.getPlayer2().toString());*/
        }
}
