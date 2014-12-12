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

import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;


public class ChooseUnits extends FragmentActivity {

    Button CU1;
    Button CU2;
    Button CU3;

    String unit1;
    String unit2;
    String unit3;

    HashMap<Drawable,String> playerTeamHashMap;
    ArrayList<String> playerTeam;

    String currentlySelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_units);

        final Button orc = (Button) findViewById(R.id.chooseOrc);
        final Button skeleton = (Button) findViewById(R.id.chooseSkeleton);
        final Button supplyCart = (Button) findViewById(R.id.chooseSupplyCart);
        final Button thief = (Button) findViewById(R.id.chooseThief);
        final Button vampire = (Button) findViewById(R.id.chooseVampire);
        final Button defender = (Button) findViewById(R.id.chooseDefender);
        final Button dwarf = (Button) findViewById(R.id.chooseDwarf);
        final Button golem = (Button) findViewById(R.id.chooseGolem);
        final Button mushroom = (Button) findViewById(R.id.chooseMushroom);
        final Button archer = (Button) findViewById(R.id.chooseArcher);
        final Button barbarian = (Button) findViewById(R.id.chooseBarbarian);
        final Button catapult = (Button) findViewById(R.id.chooseCatapult);
        final Button footsoldier = (Button) findViewById(R.id.chooseFootsoldier);
        final Button mage = (Button) findViewById(R.id.chooseMage);

        CU1 = (Button) findViewById(R.id.chosen_unit_1);
        CU2 = (Button) findViewById(R.id.chosen_unit_2);
        CU3 = (Button) findViewById(R.id.chosen_unit_3);

        CU1.setVisibility(View.INVISIBLE);
        CU2.setVisibility(View.INVISIBLE);
        CU3.setVisibility(View.INVISIBLE);

        playerTeamHashMap = new HashMap<Drawable, String>();
        playerTeam = new ArrayList<String>();

        Button playButton = (Button) findViewById(R.id.lookForOpponent);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playerTeamHashMap.size() >= 3){
                    for(Drawable d : playerTeamHashMap.keySet()){
                        playerTeam.add(playerTeamHashMap.get(d));
                    }

                    Intent i = new Intent(ChooseUnits.this, SearchingForOpponent.class);
                    i.putStringArrayListExtra("team",playerTeam);
                    startActivity(i);
                }
            }
        });

        orc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "orc";
                    unitDesc = new UnitDescriptionFragment();

                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_orc));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_orc));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_orc));

                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(orc);
                } else if(!unitDesc.getTag().equals("orc")) {
                    currentlySelected = "orc";
                    unitDesc = new UnitDescriptionFragment();

                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_orc));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_orc));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_orc));

                    unitDesc.setCurrOpen(orc);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        skeleton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "skeleton";
                    unitDesc = new UnitDescriptionFragment();

                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_skeleton));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_skeleton));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_skeleton));

                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(skeleton);
                } else if(!unitDesc.getTag().equals("skeleton")) {
                    currentlySelected = "skeleton";
                    unitDesc = new UnitDescriptionFragment();

                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_skeleton));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_skeleton));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_skeleton));

                    unitDesc.setCurrOpen(skeleton);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        supplyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "supplyCart";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_supplyCart));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_supplyCart));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_supplyCart));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(supplyCart);
                } else if (!unitDesc.getTag().equals("supplyCart")) {
                    currentlySelected = "supplyCart";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_supplyCart));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_supplyCart));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_supplyCart));
                    unitDesc.setCurrOpen(supplyCart);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container, unitDesc, currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        thief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "thief";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_thief));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_thief));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_thief));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(thief);
                } else if(!unitDesc.getTag().equals("thief")) {
                    currentlySelected = "thief";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_thief));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_thief));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_thief));
                    unitDesc.setCurrOpen(thief);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        vampire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "vampire";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_vampire));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_vampire));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_vampire));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(vampire);
                } else if(!unitDesc.getTag().equals("vampire")) {
                    currentlySelected = "vampire";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_vampire));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_vampire));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_vampire));
                    unitDesc.setCurrOpen(vampire);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        defender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "defender";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_defender));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_defender));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_defender));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(defender);
                } else if(!unitDesc.getTag().equals("defender")) {
                    currentlySelected = "defender";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_defender));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_defender));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_defender));
                    unitDesc.setCurrOpen(defender);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        dwarf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "dwarf";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_dwarf));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_dwarf));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_dwarf));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(dwarf);
                } else if(!unitDesc.getTag().equals("dwarf")) {
                    currentlySelected = "dwarf";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_dwarf));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_dwarf));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_dwarf));
                    unitDesc.setCurrOpen(dwarf);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        golem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "golem";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_golem));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_golem));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_golem));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(golem);
                } else if(!unitDesc.getTag().equals("golem")) {
                    currentlySelected = "golem";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_golem));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_golem));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_golem));
                    unitDesc.setCurrOpen(golem);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        mushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "mushroom";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_mushroom));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_mushroom));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_mushroom));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(mushroom);
                } else if(!unitDesc.getTag().equals("mushroom")) {
                    currentlySelected = "mushroom";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_mushroom));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_mushroom));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_mushroom));
                    unitDesc.setCurrOpen(mushroom);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        archer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "archer";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_archer));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_archer));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_archer));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(archer);
                } else if(!unitDesc.getTag().equals("archer")) {
                    currentlySelected = "archer";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_archer));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_archer));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_archer));
                    unitDesc.setCurrOpen(archer);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        barbarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "barbarian";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_barbarian));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_barbarian));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_barbarian));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(barbarian);
                } else if(!unitDesc.getTag().equals("barbarian")) {
                    currentlySelected = "barbarian";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_barbarian));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_barbarian));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_barbarian));
                    unitDesc.setCurrOpen(barbarian);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        catapult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "catapult";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_catapult));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_catapult));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_catapult));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(catapult);
                } else if(!unitDesc.getTag().equals("catapult")) {
                    currentlySelected = "catapult";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_catapult));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_catapult));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_catapult));
                    unitDesc.setCurrOpen(catapult);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        footsoldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "footsoldier";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_footsoldier));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_footsoldier));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_footsoldier));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(footsoldier);
                } else if(!unitDesc.getTag().equals("footsoldier")) {
                    currentlySelected = "footsoldier";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_footsoldier));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_footsoldier));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_footsoldier));
                    unitDesc.setCurrOpen(footsoldier);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });
        mage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "mage";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_mage));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_mage));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_mage));
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(mage);
                } else if(!unitDesc.getTag().equals("mage")) {
                    currentlySelected = "mage";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setUnitName(getResources().getString(R.string.unit_name_mage));
                    unitDesc.setUnitAbilityName(getResources().getString(R.string.unit_ability_name_mage));
                    unitDesc.setUnitAbilityCost(getResources().getString(R.string.unit_ability_cost_mage));
                    unitDesc.setCurrOpen(mage);
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.fragment_container,unitDesc,currentlySelected).commit();
                } else {
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                    currentlySelected = null;
                }
            }
        });

        CU1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if (CU1.getVisibility() == View.VISIBLE) {
                    CU1.setVisibility(View.INVISIBLE);
                    playerTeamHashMap.remove(CU1.getBackground());
                    CU1.setBackground(null);
                }
            }
        });
        CU2.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if (CU2.getVisibility() == View.VISIBLE) {
                    CU2.setVisibility(View.INVISIBLE);
                    playerTeamHashMap.remove(CU2.getBackground());
                    CU2.setBackground(null);
                }
            }
        });
        CU3.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if (CU3.getVisibility() == View.VISIBLE) {
                    CU3.setVisibility(View.INVISIBLE);
                    playerTeamHashMap.remove(CU3.getBackground());
                    CU3.setBackground(null);
                }
            }
        });
    }

    //add unit to picked
    public void addUnit(Button picked, String name) {
        if (!checkIfPicked(picked)) {
            chooseUnit(picked);
            picked.setTag(name);
            playerTeamHashMap.put(picked.getBackground(), currentlySelected);
        }
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(getFragmentManager().findFragmentByTag(currentlySelected)).commit();
        currentlySelected = null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void chooseUnit(Button chosenUnit) {
        Drawable chosenUnitBackground = chosenUnit.getBackground();
        ArrayList<Button> pickedList = getPickedList();
        int i = 0;
        for (Button m : pickedList) {
            if (m.getVisibility() == View.INVISIBLE && i == 0) {
                m.setBackground(chosenUnitBackground);
                m.setVisibility(View.VISIBLE);
                i++;
            }
        }
    }

    public ArrayList<Button> getPickedList() {
        ArrayList<Button> pickedList = new ArrayList<Button>();
        pickedList.add(CU1);
        pickedList.add(CU2);
        pickedList.add(CU3);
        return pickedList;
    }

    public boolean checkIfPicked(Button picked) {
        boolean p = false;
        for (Button b : getPickedList()) {
            if (b.getBackground() == picked.getBackground()) {
                p = true;
            }
        }
        return p;
    }
}