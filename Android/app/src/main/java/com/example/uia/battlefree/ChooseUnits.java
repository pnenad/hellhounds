package com.example.uia.battlefree;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ChooseUnits extends FragmentActivity {

    Button CU1;
    Button CU2;
    Button CU3;

    String unit1;
    String unit2;
    String unit3;

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

        CU1 = (Button) findViewById(R.id.chosen_unit_1);
        CU2 = (Button) findViewById(R.id.chosen_unit_2);
        CU3 = (Button) findViewById(R.id.chosen_unit_3);

        CU1.setVisibility(View.INVISIBLE);
        CU2.setVisibility(View.INVISIBLE);
        CU3.setVisibility(View.INVISIBLE);

        Button playButton = (Button) findViewById(R.id.lookForOpponent);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseUnits.this, SearchingForOpponent.class);

                /*ArrayList<String> nameList = new ArrayList<String>();
                ArrayList<String> abilityList = new ArrayList<String>();

                i.putStringArrayListExtra("nameList",nameList);
                i.putStringArrayListExtra("abilityList",abilityList);*/
            }
        });

        orc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag(currentlySelected);
                if (unitDesc == null) {
                    currentlySelected = "orc";
                    unitDesc = new UnitDescriptionFragment();
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(orc);
                } else if(!unitDesc.getTag().equals("orc")) {
                    currentlySelected = "orc";
                    unitDesc = new UnitDescriptionFragment();
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
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(skeleton);
                } else if(!unitDesc.getTag().equals("skeleton")) {
                    currentlySelected = "skeleton";
                    unitDesc = new UnitDescriptionFragment();
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
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(supplyCart);
                } else if (!unitDesc.getTag().equals("supplyCart")) {
                    currentlySelected = "supplyCart";
                    unitDesc = new UnitDescriptionFragment();
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
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(thief);
                } else if(!unitDesc.getTag().equals("thief")) {
                    currentlySelected = "thief";
                    unitDesc = new UnitDescriptionFragment();
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
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container, unitDesc, currentlySelected).commit();
                    unitDesc.setCurrOpen(vampire);
                } else if(!unitDesc.getTag().equals("vampire")) {
                    currentlySelected = "vampire";
                    unitDesc = new UnitDescriptionFragment();
                    unitDesc.setCurrOpen(vampire);
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
                    CU3.setBackground(null);
                }
            }
        });
    }

    //add unit to picked
    public void addUnit(Button picked) {
        if (!checkIfPicked(picked)) {
            chooseUnit(picked);
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