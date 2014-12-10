package com.example.uia.battlefree;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class Game extends FragmentActivity {

    String currentlySelected;

    Button enemyUnit1;
    Button enemyUnit2;
    Button enemyUnit3;

    Button playerUnit1;
    Button playerUnit2;
    Button playerUnit3;

    ArrayList<Integer> targets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        currentlySelected = null;

        targets = new ArrayList<Integer>();

        playerUnit1 = (Button) findViewById(R.id.playerUnit1);
        playerUnit2 = (Button) findViewById(R.id.playerUnit2);
        playerUnit3 = (Button) findViewById(R.id.playerUnit3);

        enemyUnit1 = (Button) findViewById(R.id.enemyUnit1);
        enemyUnit2 = (Button) findViewById(R.id.enemyUnit2);
        enemyUnit3 = (Button) findViewById(R.id.enemyUnit3);

        final boolean[] targeting = {false};

        playerUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerUnitViewFragment playerUnitDesc = (PlayerUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                EnemyUnitViewFragment enemyUnitDesc = (EnemyUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                targeting[0] = false;
                if (playerUnitDesc == null) {
                    currentlySelected = "playerUnit1";
                    playerUnitDesc = new PlayerUnitViewFragment();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left, R.transition.exit_to_left).add(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                }else if(!playerUnitDesc.getTag().equals("playerUnit1")) {
                    currentlySelected = "playerUnit1";
                    playerUnitDesc = new PlayerUnitViewFragment();
                    getFragmentManager().beginTransaction().replace(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right,R.transition.enter_from_right).remove(playerUnitDesc).commit();
                    currentlySelected = null;
                }
            }
        });

        enemyUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(targeting[0]){
                    if(targets.contains(enemyUnit1.getId())){
                        targets.remove(enemyUnit1.getId());
                    }else{
                        targets.add(enemyUnit1.getId());
                    }
                }else{
                    PlayerUnitViewFragment playerUnitDesc = (PlayerUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                    EnemyUnitViewFragment enemyUnitDesc = (EnemyUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                    if (playerUnitDesc == null) {
                        currentlySelected = "enemyUnit1";
                        playerUnitDesc = new PlayerUnitViewFragment();
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right, R.transition.enter_from_right).add(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                    }else if(!playerUnitDesc.getTag().equals("enemyUnit1")) {
                        currentlySelected = "enemyUnit1";
                        playerUnitDesc = new PlayerUnitViewFragment();
                        getFragmentManager().beginTransaction().replace(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                    } else {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_enemy,R.transition.enter_from_left).remove(playerUnitDesc).commit();
                        currentlySelected = null;
                    }
                }

            }
        });
    }

    public void targeting(){
        final ArrayList<Integer> targets = new ArrayList<Integer>();
        final boolean[] targeting = {true};
        }
}
