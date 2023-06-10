package com.example.unitconvertor.convertortype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.unitconvertor.databinding.ActivityTimeBinding;

import java.util.ArrayList;
import java.util.List;

public class TimeActivity extends AppCompatActivity {
    String a = "Hours", b = "Minutes",  c = "Seconds";
    public  String secondSSData;
    public  String firstSSData;
  ActivityTimeBinding timeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timeBinding =  ActivityTimeBinding.inflate(getLayoutInflater());
        setContentView(timeBinding.getRoot());

        getSupportActionBar().setTitle("Time Convertor");


        // first Spinner Drop down elements
        List<String> firstSpinnerData = new ArrayList<String>();
        firstSpinnerData.add(a);
        firstSpinnerData.add(b);
        firstSpinnerData.add(c);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, firstSpinnerData);
        firstSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        timeBinding.firstSpinner.setAdapter(firstSpinnerAdapter);
        //first spinner ends

        //second spinner funciton

        List<String> secondSpinnerData = new ArrayList<String>();

        secondSpinnerData.add(a);
        secondSpinnerData.add(b);
        secondSpinnerData.add(c);
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secondSpinnerData);
        secondSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeBinding.secondSpinner.setAdapter(secondSpinnerAdapter);
        firstSSData =  timeBinding.firstSpinner.getSelectedItem().toString();
        secondSSData = timeBinding.secondSpinner.getSelectedItem().toString();
        // second spinner ends here


        //selection part start here
        timeBinding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                secondSSData =  adapterView.getSelectedItem().toString();
                if(!timeBinding.secondEdittext.getText().toString().isEmpty()){
                    timeBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        timeBinding.secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstSSData =  adapterView.getSelectedItem().toString();
                if(!timeBinding.secondEdittext.getText().toString().isEmpty()){
                    timeBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // selection part end here


        timeBinding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double get_first_num = Double.parseDouble(timeBinding.secondEdittext.getText().toString());

                if(firstSSData ==a && secondSSData==a){

                    timeBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==a && secondSSData==b){

                    get_first_num =  60*get_first_num;
                    timeBinding.firstText.setText(Double.toString(get_first_num));


                }else if (firstSSData ==a && secondSSData==c){

                    get_first_num =  60*60*get_first_num;
                    timeBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b&& secondSSData==a){
                    get_first_num =  get_first_num/ 60;
                    timeBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b && secondSSData==b){

                    get_first_num =  get_first_num;
                    timeBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b && secondSSData==c){
                    get_first_num =  get_first_num * 60;
                    timeBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==c && secondSSData==a){
                    get_first_num =  (get_first_num/60)/60;
                    timeBinding.firstText.setText(Double.toString(get_first_num));
                }else if(firstSSData ==c && secondSSData==b){
                    get_first_num =  get_first_num/60;
                    timeBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==c && secondSSData==c){
                    get_first_num =  get_first_num;

                    timeBinding.firstText.setText(Double.toString(get_first_num));
                }


            }
        });

    }
}