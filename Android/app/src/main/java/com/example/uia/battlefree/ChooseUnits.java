package com.example.uia.battlefree;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ChooseUnits extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_units);

        final Button chooseUnit1 = (Button) findViewById(R.id.unit_button_1);
        final Button chooseUnit2 = (Button) findViewById(R.id.unit_button_2);
        final Button chooseUnit3 = (Button) findViewById(R.id.unit_button_3);
        final Button chooseUnit4 = (Button) findViewById(R.id.unit_button_4);
        final Button chooseUnit5 = (Button) findViewById(R.id.unit_button_5);
        final Button chooseUnit6 = (Button) findViewById(R.id.unit_button_6);

        chooseUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonBackground(chooseUnit1, view);
            }
        });
    }

    public void setButtonBackground(Button b, View v) {
        final Button CU1 = (Button) findViewById(R.id.chosen_unit_1);
        final Button CU2 = (Button) findViewById(R.id.chosen_unit_2);
        final Button CU3 = (Button) findViewById(R.id.chosen_unit_3);
        TextView t = (TextView)findViewById(R.id.textView2);



        Drawable chosenUnitBackground = b.getBackground();

        ArrayList<Button> bArray = new ArrayList<Button>();
        bArray.add(CU1);
        bArray.add(CU2);
        bArray.add(CU3);

        for (int i = 0; i < bArray.size(); i++) {
            Button chosenUnit = bArray.get(i);
            int visibility = chosenUnit.getVisibility();
            System.out.println(visibility);
            t.setText(""+visibility);
            if (visibility == 4) {
                chosenUnit.setBackground(getResources().getDrawable(R.drawable.orcbigger));
                chosenUnit.setVisibility(View.VISIBLE);
            }
        }
        bArray.clear();
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
