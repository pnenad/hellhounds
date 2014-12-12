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
package com.hellhounds.battlefree.android;

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

    PlayerUnitViewFragment playerUnitDesc;
    EnemyUnitViewFragment enemyUnitDesc;
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
                if(currentlySelected != null) {
                    if (currentlySelected.startsWith("e")) {
                        currentlySelected = null;
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.exit_enemy).remove(enemyUnitDesc).commit();
                    }
                }
                playerUnitDesc = (PlayerUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
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

        playerUnit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentlySelected != null) {
                    if (currentlySelected.startsWith("e")) {
                        currentlySelected = null;
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.exit_enemy).remove(enemyUnitDesc).commit();
                    }
                }
                playerUnitDesc = (PlayerUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                targeting[0] = false;
                if (playerUnitDesc == null) {
                    currentlySelected = "playerUnit2";
                    playerUnitDesc = new PlayerUnitViewFragment();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left, R.transition.exit_to_left).add(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                }else if(!playerUnitDesc.getTag().equals("playerUnit2")) {
                    currentlySelected = "playerUnit2";
                    playerUnitDesc = new PlayerUnitViewFragment();
                    getFragmentManager().beginTransaction().replace(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right,R.transition.enter_from_right).remove(playerUnitDesc).commit();
                    currentlySelected = null;
                }
            }
        });

        playerUnit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentlySelected != null) {
                    if (currentlySelected.startsWith("e")) {
                        currentlySelected = null;
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.exit_enemy).remove(enemyUnitDesc).commit();
                    }
                }
                playerUnitDesc = (PlayerUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                targeting[0] = false;
                if (playerUnitDesc == null) {
                    currentlySelected = "playerUnit3";
                    playerUnitDesc = new PlayerUnitViewFragment();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left, R.transition.exit_to_left).add(R.id.unitDescriptionFragmentContainer, playerUnitDesc, currentlySelected).commit();
                }else if(!playerUnitDesc.getTag().equals("playerUnit3")) {
                    currentlySelected = "playerUnit3";
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
                    if (targeting[0]) {
                        if (targets.contains(enemyUnit1.getId())) {
                            targets.remove(enemyUnit1.getId());
                        } else {
                            targets.add(enemyUnit1.getId());
                        }
                    } else {
                        if(currentlySelected != null) {
                            if (currentlySelected.startsWith("p")) {
                                currentlySelected = null;
                                getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right,R.transition.enter_from_right).remove(playerUnitDesc).commit();
                            }
                        }
                        enemyUnitDesc = (EnemyUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                        if (enemyUnitDesc == null) {
                            currentlySelected = "enemyUnit1";
                            enemyUnitDesc = new EnemyUnitViewFragment();
                            getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right, R.transition.enter_from_right).add(R.id.unitDescriptionFragmentContainer, enemyUnitDesc, currentlySelected).commit();
                        } else if (!enemyUnitDesc.getTag().equals("enemyUnit1")) {
                            currentlySelected = "enemyUnit1";
                            enemyUnitDesc = new EnemyUnitViewFragment();
                            getFragmentManager().beginTransaction().replace(R.id.unitDescriptionFragmentContainer, enemyUnitDesc, currentlySelected).commit();
                        } else {
                            getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.exit_enemy).remove(enemyUnitDesc).commit();
                            currentlySelected = null;
                        }
                    }
                }
        });

        enemyUnit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (targeting[0]) {
                    if (targets.contains(enemyUnit2.getId())) {
                        targets.remove(enemyUnit2.getId());
                    } else {
                        targets.add(enemyUnit2.getId());
                    }
                } else {
                    if(currentlySelected != null) {
                        if (currentlySelected.startsWith("p")) {
                            currentlySelected = null;
                            getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right,R.transition.enter_from_right).remove(playerUnitDesc).commit();
                        }
                    }
                    enemyUnitDesc = (EnemyUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                    if (enemyUnitDesc == null) {
                        currentlySelected = "enemyUnit2";
                        enemyUnitDesc = new EnemyUnitViewFragment();
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right, R.transition.enter_from_right).add(R.id.unitDescriptionFragmentContainer, enemyUnitDesc, currentlySelected).commit();
                    } else if (!enemyUnitDesc.getTag().equals("enemyUnit2")) {
                        currentlySelected = "enemyUnit2";
                        enemyUnitDesc = new EnemyUnitViewFragment();
                        getFragmentManager().beginTransaction().replace(R.id.unitDescriptionFragmentContainer, enemyUnitDesc, currentlySelected).commit();
                    } else {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.exit_enemy).remove(enemyUnitDesc).commit();
                        currentlySelected = null;
                    }
                }
            }
        });

        enemyUnit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (targeting[0]) {
                    if (targets.contains(enemyUnit3.getId())) {
                        targets.remove(enemyUnit3.getId());
                    } else {
                        targets.add(enemyUnit3.getId());
                    }
                } else {
                    if(currentlySelected != null) {
                        if (currentlySelected.startsWith("p")) {
                            currentlySelected = null;
                            getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right,R.transition.enter_from_right).remove(playerUnitDesc).commit();
                        }
                    }
                    enemyUnitDesc = (EnemyUnitViewFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                    if (enemyUnitDesc == null) {
                        currentlySelected = "enemyUnit3";
                        enemyUnitDesc = new EnemyUnitViewFragment();
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.exit_to_right, R.transition.enter_from_right).add(R.id.unitDescriptionFragmentContainer, enemyUnitDesc, currentlySelected).commit();
                    } else if (!enemyUnitDesc.getTag().equals("enemyUnit3")) {
                        currentlySelected = "enemyUnit3";
                        enemyUnitDesc = new EnemyUnitViewFragment();
                        getFragmentManager().beginTransaction().replace(R.id.unitDescriptionFragmentContainer, enemyUnitDesc, currentlySelected).commit();
                    } else {
                        getFragmentManager().beginTransaction().setCustomAnimations(R.transition.enter_from_left,R.transition.exit_enemy).remove(enemyUnitDesc).commit();
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
