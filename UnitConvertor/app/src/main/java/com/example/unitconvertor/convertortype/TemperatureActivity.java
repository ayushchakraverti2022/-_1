package com.example.unitconvertor.convertortype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.unitconvertor.databinding.ActivityTemperatureBinding;

import java.util.ArrayList;
import java.util.List;

public class TemperatureActivity extends AppCompatActivity {
    String a = "Celsius", b = "Fahrenheit";
    public  String secondSSData;
    public  String firstSSData;
    ActivityTemperatureBinding temperatureBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        temperatureBinding =  ActivityTemperatureBinding.inflate(getLayoutInflater());
        setContentView(temperatureBinding.getRoot());

        getSupportActionBar().setTitle("Temperature Convertor");


        // first Spinner Drop down elements
        List<String> firstSpinnerData = new ArrayList<String>();
        firstSpinnerData.add(a);
        firstSpinnerData.add(b);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, firstSpinnerData);
        firstSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        temperatureBinding.firstSpinner.setAdapter(firstSpinnerAdapter);
        //first spinner ends

        //second spinner funciton

        List<String> secondSpinnerData = new ArrayList<String>();

        secondSpinnerData.add(a);
        secondSpinnerData.add(b);

        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secondSpinnerData);
        secondSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperatureBinding.secondSpinner.setAdapter(secondSpinnerAdapter);
        firstSSData =  temperatureBinding.firstSpinner.getSelectedItem().toString();
        secondSSData = temperatureBinding.secondSpinner.getSelectedItem().toString();
        // second spinner ends here


        //selection part start here
        temperatureBinding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                secondSSData =  adapterView.getSelectedItem().toString();
                if(!temperatureBinding.secondEdittext.getText().toString().isEmpty()){
                    temperatureBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        temperatureBinding.secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstSSData =  adapterView.getSelectedItem().toString();
                if(!temperatureBinding.secondEdittext.getText().toString().isEmpty()){
                    temperatureBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // selection part end here


        temperatureBinding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double get_first_num = Double.parseDouble(temperatureBinding.secondEdittext.getText().toString());

                if(firstSSData ==a && secondSSData==a){

                    temperatureBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==a && secondSSData==b){

                    get_first_num = (9*get_first_num)/5 +32;
                    temperatureBinding.firstText.setText(Double.toString(get_first_num));


                }else if (firstSSData ==b && secondSSData==b){
                    temperatureBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b&& secondSSData==a){
                    get_first_num =((get_first_num-32)*5)/9;
                    temperatureBinding.firstText.setText(Double.toString(get_first_num));

                }


            }
        });
    }
}