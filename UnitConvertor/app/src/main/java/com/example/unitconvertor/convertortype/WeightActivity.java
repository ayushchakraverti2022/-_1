package com.example.unitconvertor.convertortype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.unitconvertor.databinding.ActivityWeightBinding;

import java.util.ArrayList;
import java.util.List;

public class WeightActivity extends AppCompatActivity {
    String a = "Kilogram", b = "gram",  c = "miligram";
    public  String secondSSData;
    public  String firstSSData;
     ActivityWeightBinding weightBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weightBinding = ActivityWeightBinding.inflate(getLayoutInflater());
        setContentView(weightBinding.getRoot());

        getSupportActionBar().setTitle("Weight Convertor");


        // first Spinner Drop down elements
        List<String> firstSpinnerData = new ArrayList<String>();
        firstSpinnerData.add(a);
        firstSpinnerData.add(b);
        firstSpinnerData.add(c);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, firstSpinnerData);
        firstSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        weightBinding.firstSpinner.setAdapter(firstSpinnerAdapter);
        //first spinner ends

        //second spinner funciton

        List<String> secondSpinnerData = new ArrayList<String>();

        secondSpinnerData.add(a);
        secondSpinnerData.add(b);
        secondSpinnerData.add(c);
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secondSpinnerData);
        secondSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightBinding.secondSpinner.setAdapter(secondSpinnerAdapter);
        firstSSData =  weightBinding.firstSpinner.getSelectedItem().toString();
        secondSSData = weightBinding.secondSpinner.getSelectedItem().toString();
        // second spinner ends here


        //selection part start here
        weightBinding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                secondSSData =  adapterView.getSelectedItem().toString();
                if(!weightBinding.secondEdittext.getText().toString().isEmpty()){
                    weightBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        weightBinding.secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstSSData =  adapterView.getSelectedItem().toString();
                if(!weightBinding.secondEdittext.getText().toString().isEmpty()){
                    weightBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // selection part end here


        weightBinding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double get_first_num = Double.parseDouble(weightBinding.secondEdittext.getText().toString());

                if(firstSSData ==a && secondSSData==a){

                    weightBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==a && secondSSData==b){

                    get_first_num =  1000*get_first_num;
                    weightBinding.firstText.setText(Double.toString(get_first_num));


                }else if (firstSSData ==a && secondSSData==c){

                    get_first_num =  1000*1000*get_first_num;
                    weightBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b&& secondSSData==a){
                    get_first_num =  get_first_num/ 1000;
                    weightBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b && secondSSData==b){

                    get_first_num =  get_first_num;
                    weightBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b && secondSSData==c){
                    get_first_num =  get_first_num * 1000;
                    weightBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==c && secondSSData==a){
                    get_first_num =  (get_first_num/1000)/1000;
                    weightBinding.firstText.setText(Double.toString(get_first_num));
                }else if(firstSSData ==c && secondSSData==b){
                    get_first_num =  get_first_num/1000;
                    weightBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==c && secondSSData==c){
                    get_first_num =  get_first_num;

                    weightBinding.firstText.setText(Double.toString(get_first_num));
                }


            }
        });

    }
}