package com.example.uia.battlefree;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;

import java.util.ArrayList;


public class SearchingForOpponent extends Activity {

    ImageView unit1;
    ImageView unit2;
    ImageView unit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_for_opponent);

        ProgressBar spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        Bundle i = new Intent().getExtras();

        unit1 = (ImageView) findViewById(R.id.unit1);
        unit2 = (ImageView) findViewById(R.id.unit2);
        unit3 = (ImageView) findViewById(R.id.unit3);

        Button testButton = (Button) findViewById(R.id.test);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchingForOpponent.this, Game.class));
            }
        });

        ArrayList<String> list;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                list = null;
            } else {
                list = extras.getStringArrayList("team");
            }
        } else {
            list = (ArrayList<String>) savedInstanceState.getSerializable("getList");
        }

        assert list != null;
        for(int k = 0; k < list.size();k++) {
            String s = list.get(k);
            switch (k) {
                case 0:
                    setTeam(s,unit1);
                    break;
                case 1:
                    setTeam(s,unit2);
                    break;
                case 2:
                    setTeam(s,unit3);
                    break;
                default:
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setTeam(String s, ImageView imgView){
        int resID;
        if (s.equals("orc")) {
            resID = getResources().getIdentifier("orc", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("skeleton")) {
            resID = getResources().getIdentifier("skeletons", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("thief")) {
            resID = getResources().getIdentifier("thief", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("supplyCart")) {
            resID = getResources().getIdentifier("supplycart", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("vampire")) {
            resID = getResources().getIdentifier("vampire", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("defender")) {
            resID = getResources().getIdentifier("defender", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("dwarf")) {
            resID = getResources().getIdentifier("dwarf", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("golem")) {
            resID = getResources().getIdentifier("golem", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("mushroom")) {
            resID = getResources().getIdentifier("mushrooms", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("archer")) {
            resID = getResources().getIdentifier("archer", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("barbarian")) {
            resID = getResources().getIdentifier("barbarian", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("catapult")) {
            resID = getResources().getIdentifier("catapult", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("footsoldier")) {
            resID = getResources().getIdentifier("footsoldiers", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        } else if (s.equals("mage")) {
            resID = getResources().getIdentifier("mage", "drawable", SearchingForOpponent.this.getPackageName());
            imgView.setBackground(getResources().getDrawable(resID));

        }
    }
}
