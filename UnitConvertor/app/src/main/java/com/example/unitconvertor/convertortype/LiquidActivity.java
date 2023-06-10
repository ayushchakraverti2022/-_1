package com.example.unitconvertor.convertortype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.unitconvertor.databinding.ActivityLiquidBinding;

import java.util.ArrayList;
import java.util.List;

public class LiquidActivity extends AppCompatActivity {
     ActivityLiquidBinding  liquidBinding;
    String a = "Kilolitre", b = "Litre",  c = "mililitre";
     public  String secondSSData;
     public  String firstSSData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        liquidBinding =  ActivityLiquidBinding.inflate(getLayoutInflater());

        setContentView(liquidBinding.getRoot());;
        getSupportActionBar().setTitle("Liquid/Volume Convertor");


        // first Spinner Drop down elements
        List<String> firstSpinnerData = new ArrayList<String>();
        firstSpinnerData.add(a);
        firstSpinnerData.add(b);
        firstSpinnerData.add(c);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, firstSpinnerData);
        firstSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        liquidBinding.firstSpinner.setAdapter(firstSpinnerAdapter);
        //first spinner ends

       //second spinner funciton

        List<String> secondSpinnerData = new ArrayList<String>();

        secondSpinnerData.add(a);
        secondSpinnerData.add(b);
        secondSpinnerData.add(c);
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secondSpinnerData);
        secondSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liquidBinding.secondSpinner.setAdapter(secondSpinnerAdapter);
        firstSSData =  liquidBinding.firstSpinner.getSelectedItem().toString();
        secondSSData = liquidBinding.secondSpinner.getSelectedItem().toString();
        // second spinner ends here


        //selection part start here
        liquidBinding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                secondSSData =  adapterView.getSelectedItem().toString();
                if(!liquidBinding.secondEdittext.getText().toString().isEmpty()){
                    liquidBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        liquidBinding.secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstSSData =  adapterView.getSelectedItem().toString();
                if(!liquidBinding.secondEdittext.getText().toString().isEmpty()){
                    liquidBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // selection part end here


        liquidBinding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 double get_first_num = Double.parseDouble(liquidBinding.secondEdittext.getText().toString());

                 if(firstSSData ==a && secondSSData==a){

                     liquidBinding.firstText.setText(Double.toString(get_first_num));

                 }else if(firstSSData ==a && secondSSData==b){

                     get_first_num =  1000*get_first_num;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));


                 }else if (firstSSData ==a && secondSSData==c){

                     get_first_num =  1000*1000*get_first_num;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));

                 }else if(firstSSData ==b&& secondSSData==a){
                     get_first_num =  get_first_num/ 1000;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));

                 }else if(firstSSData ==b && secondSSData==b){

                     get_first_num =  get_first_num;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));

                 }else if(firstSSData ==b && secondSSData==c){
                     get_first_num =  get_first_num * 1000;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));

                 }else if(firstSSData ==c && secondSSData==a){
                     get_first_num =  (get_first_num/1000)/1000;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));
                 }else if(firstSSData ==c && secondSSData==b){
                     get_first_num =  get_first_num/1000;
                     liquidBinding.firstText.setText(Double.toString(get_first_num));

                 }else if(firstSSData ==c && secondSSData==c){
                     get_first_num =  get_first_num;

                     liquidBinding.firstText.setText(Double.toString(get_first_num));
                 }


            }
        });






    }
}