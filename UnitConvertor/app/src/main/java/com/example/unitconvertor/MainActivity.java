package com.example.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.unitconvertor.convertortype.*;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView unitscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitscard = findViewById(R.id.chooseunit);
        ArrayList<ModelClass> unitcardarray = new ArrayList<>();

        unitcardarray.add(new ModelClass("Weight", R.drawable.equipment_1300059));
        unitcardarray.add(new ModelClass("Length", R.drawable.ruler_146428));
        unitcardarray.add(new ModelClass("Time", R.drawable.baseline_access_time_24));
        unitcardarray.add(new ModelClass("Temperature", R.drawable.cold_1293305));
        unitcardarray.add(new ModelClass("Liquid", R.drawable.chemistry_155121));
        unitcardarray.add(new ModelClass("Data", R.drawable.database_152091));

        UnitAdapter adapter = new UnitAdapter(this, unitcardarray);
        unitscard.setAdapter(adapter);
        unitscard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(l==0){
                       Intent ji = new Intent(MainActivity.this,WeightActivity.class );
                       startActivity(ji);
                   }else if(l==1){
                       Intent ii = new Intent(MainActivity.this, LengthActivity.class);
                       startActivity(ii);
                   }else if(l==2){
                       Intent ii = new Intent(MainActivity.this, TimeActivity.class);
                       startActivity(ii);
                   }else if(l==3){
                       Intent ii = new Intent(MainActivity.this, TemperatureActivity.class);
                       startActivity(ii);
                   }else if(l==4){
                       Intent ii = new Intent(MainActivity.this, LiquidActivity.class);
                       startActivity(ii);
                   }else if(l==5){
                       Intent ii = new Intent(MainActivity.this, DataActivity.class);
                       startActivity(ii);
                   }

            }
        });

    }
}