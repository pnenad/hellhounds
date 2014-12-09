package com.example.uia.battlefree;

import android.app.Activity;
import android.content.Intent;
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

    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_for_opponent);

        spinner = (ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        Button testButton = (Button) findViewById(R.id.test);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchingForOpponent.this, Game.class));
            }
        });

        /*
        int[] list;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                list = null;
            } else {
                list = extras.getIntArray("getList");
            }
        } else {
            list = (int[]) savedInstanceState.getSerializable("getList");
        }
    }

    public void yourTeam(int[] l){
       for (int i = 0; i < l.length;i++){
           int s = l[i];

           ImageView img = (ImageView) findViewById();
           img.setBackground(getResources().getDrawable());
       }*/
    }
}
