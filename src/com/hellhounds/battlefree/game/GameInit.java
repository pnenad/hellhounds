package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.effects.EffectType;
import com.hellhounds.battlefree.game.units.*;
import com.hellhounds.battlefree.messaging.*;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class GameInit{

    public static void main(String[] args)
    {
        
        Player p1 = new Player("Mannebind", new Mage(), new Archer(),
                               new Defender());

        Player p2 = new Player("iEzpeN", new Supplycart(), new Thief(),
                               new Catapult());

        Game game = new Game(p1, p2, 1);

/*
        p1.getUnit1().getAbility().setActivated(true);
        p1.getUnit1().getAbility().getPrimary().addTarget(p2.getUnit1());
        p1.getUnit1().getAbility().getSecondary().addTarget(p1.getUnit1());

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

        p2.getUnit1().getAbility().setActivated(true);
        p2.getUnit1().getAbility().getPrimary().addTarget(p2.getUnit1());
        p2.getUnit1().getAbility().getSecondary().addTarget(p1.getUnit3());
*/
/*
        JsonUnit[] actions = new JsonUnit[p2.getUnits().length];
        int index = 0;
        for(Unit unit : p2.getUnits()) {
            actions[index++] = new Serializer().generateJsonUnit(unit);
        }

        TargetsMessage targetsMessage = new TargetsMessage(123, "iEzpeN", actions);
*/
        Gson gson = new GsonBuilder().create();

        //System.out.print(gson.toJson(targetsMessage));

        String player1String = "{\"gameID\":123,\"fromUsername\":\"Mannebind\",\"actions\":[{\"unitName\":\"Mage\",\"health\":100,\"activated\":true,\"primaryTargets\":[{\"targetUsername\":\"iEzpeN\",\"targetUnitName\":\"Supplycart\"}],\"secondaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Mage\"}]},{\"unitName\":\"Archer\",\"health\":100,\"activated\":false,\"primaryTargets\":[],\"secondaryTargets\":[]},{\"unitName\":\"Defender\",\"health\":100,\"activated\":true,\"primaryTargets\":[{\"targetUsername\":\"iEzpeN\",\"targetUnitName\":\"Supplycart\"}],\"secondaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Mage\"},{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Archer\"},{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Defender\"}]}],\"type\":\"TARGETS\"}\n";

        String player2String = "{\"gameID\":123,\"fromUsername\":\"iEzpeN\",\"actions\":[{\"unitName\":\"Supplycart\",\"health\":100,\"activated\":true,\"primaryTargets\":[{\"targetUsername\":\"iEzpeN\",\"targetUnitName\":\"Supplycart\"}],\"secondaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Defender\"}]},{\"unitName\":\"Thief\",\"health\":100,\"activated\":true,\"primaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Defender\"}],\"secondaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Defender\"}]},{\"unitName\":\"Catapult\",\"health\":100,\"activated\":true,\"primaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Archer\"}],\"secondaryTargets\":[{\"targetUsername\":\"Mannebind\",\"targetUnitName\":\"Mage\"}]}],\"type\":\"TARGETS\"}";

        TargetsMessage player1Message = gson.fromJson(player1String, TargetsMessage.class);
        TargetsMessage player2Message = gson.fromJson(player2String, TargetsMessage.class);

        game.resolveTargetsMessage(player1Message);
        game.resolveTargetsMessage(player2Message);

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

        //------------ JSON





        //JsonPlayer test = new Serializer().generateJsonPlayer(p1);

       // System.out.println("\n" + gson.toJson(targetsMessage));


    }
}
