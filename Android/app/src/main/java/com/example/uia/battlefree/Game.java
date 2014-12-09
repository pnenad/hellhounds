package com.example.uia.battlefree;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class Game extends Activity {

    String currentlySelected;

    Button enemyUnit1;
    Button enemyUnit2;
    Button enemyUnit3;

    Button playerUnit1;
    Button playerUnit2;
    Button playerUnit3;

    String[] targets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playerUnit1 = (Button) findViewById(R.id.playerUnit1);
        playerUnit2 = (Button) findViewById(R.id.playerUnit2);
        playerUnit3 = (Button) findViewById(R.id.playerUnit3);

        enemyUnit1 = (Button) findViewById(R.id.enemyUnit1);
        enemyUnit2 = (Button) findViewById(R.id.enemyUnit2);
        enemyUnit3 = (Button) findViewById(R.id.enemyUnit3);

        targets = new String[3];

        playerUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InGameUnitInfo unitDesc = (InGameUnitInfo) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "playerUnit1";
                    unitDesc = new InGameUnitInfo();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.enter_from_left).add(R.id.unitDescriptionFragmentContainer, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(playerUnit1);
                }else if(!unitDesc.getTag().equals("playerUnit1")) {
                    currentlySelected = "playerUnit1";
                    unitDesc = new InGameUnitInfo();
                    unitDesc.setCurrOpen(playerUnit1);
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left, R.transition.enter_from_left).replace(R.id.unitDescriptionFragmentContainer,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left, R.transition.enter_from_left).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
    }

    public ArrayList<Integer> targeting(){
        final ArrayList<Integer> targets = new ArrayList<Integer>();
        boolean targeting = true;

        while(targeting){
            enemyUnit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!targets.contains(enemyUnit1.getId())){
                        targets.add(enemyUnit1.getId());
                    }else{
                        targets.remove(enemyUnit1.getId());
                    }
                }
            });
            enemyUnit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!targets.contains(enemyUnit2.getId())){
                        targets.add(enemyUnit2.getId());
                    }else{
                        targets.remove(enemyUnit2.getId());
                    }
                }
            });
            enemyUnit3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!targets.contains(enemyUnit3.getId())){
                        targets.add(enemyUnit3.getId());
                    }else{
                        targets.remove(enemyUnit3.getId());
                    }
                }
            });
            playerUnit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //targeting = false;
                }
            });
            playerUnit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //targeting = false;
                }
            });
            playerUnit3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //targeting = false;
                }
            });
        }
        return targets;
     }
}
