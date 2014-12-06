package com.example.uia.battlefree;

import android.annotation.TargetApi;
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

import java.util.ArrayList;


public class ChooseUnits extends FragmentActivity {

    Button CU1;
    Button CU2;
    Button CU3;
    boolean isOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_units);

        final Button orc = (Button) findViewById(R.id.chooseOrc);
        final Button skeleton = (Button) findViewById(R.id.chooseSkeleton);
        final Button supplycart= (Button) findViewById(R.id.chooseSupplyCart);
        final Button thief = (Button) findViewById(R.id.chooseThief);
        final Button vampire = (Button) findViewById(R.id.chooseVampire);

        CU1 = (Button) findViewById(R.id.chosen_unit_1);
        CU2 = (Button) findViewById(R.id.chosen_unit_2);
        CU3 = (Button) findViewById(R.id.chosen_unit_3);

        CU1.setVisibility(View.INVISIBLE);
        CU2.setVisibility(View.INVISIBLE);
        CU3.setVisibility(View.INVISIBLE);

        orc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnitDescriptionFragment unitDesc = (UnitDescriptionFragment) getFragmentManager().findFragmentByTag("tag");
                if(unitDesc == null){
                    unitDesc = new UnitDescriptionFragment();
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.fragment_container,unitDesc,"tag").commit();
                    unitDesc.setCurrOpen(orc);
                }else{
                    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(unitDesc).commit();
                }
            }
        });
        skeleton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseUnit(skeleton);
            }
        });
        supplycart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseUnit(supplycart);
            }
        });
        thief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseUnit(thief);
            }
        });
        vampire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseUnit(vampire);
            }
        });


        CU1.setOnClickListener(new View.OnClickListener(){
           @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
           @Override
           public void onClick(View view){
               if(CU1.getVisibility() == View.VISIBLE){
                   CU1.setVisibility(View.INVISIBLE);
                   CU1.setBackground(null);
               }
           }
        });
        CU2.setOnClickListener(new View.OnClickListener(){
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view){
                if(CU2.getVisibility() == View.VISIBLE){
                    CU2.setVisibility(View.INVISIBLE);
                    CU2.setBackground(null);
                }
            }
        });
        CU3.setOnClickListener(new View.OnClickListener(){
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view){
                if(CU3.getVisibility() == View.VISIBLE){
                    CU3.setVisibility(View.INVISIBLE);
                    CU3.setBackground(null);
                }
            }
        });
    }

    public void addUnit(Button picked){
        if(!checkIfPicked(picked)){
            chooseUnit(picked);
        }
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(getFragmentManager().findFragmentByTag("tag")).commit();

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void chooseUnit(Button chosenUnit) {
        Drawable chosenUnitBackground = chosenUnit.getBackground();
        ArrayList<Button> pickedList = getPickedList();
        int i = 0;
        for(Button m : pickedList){
            if(m.getVisibility() == View.INVISIBLE && i == 0){
                m.setBackground(chosenUnitBackground);
                m.setVisibility(View.VISIBLE);
                i++;
            }
        }
    }

    public ArrayList<Button> getPickedList(){
        ArrayList<Button> pickedList = new ArrayList<Button>();
        pickedList.add(CU1);
        pickedList.add(CU2);
        pickedList.add(CU3);
        return pickedList;
    }

    public boolean checkIfPicked(Button pushedUnit){
        boolean picked = false;
        for(Button chosen : getPickedList()){
            if(chosen.getBackground() == pushedUnit.getBackground()){
                picked=true;
            }
        }
        return picked;
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_units, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
