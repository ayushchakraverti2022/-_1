package com.example.unitconvertor.convertortype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.unitconvertor.databinding.ActivityDataBinding;
import com.example.unitconvertor.databinding.ActivityLengthBinding;

import java.util.ArrayList;
import java.util.List;

public class LengthActivity extends AppCompatActivity {
    String a = "Kilometre", b = "metre",  c = "centimetre";
    public  String secondSSData;
    public  String firstSSData;
     ActivityLengthBinding lengthBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lengthBinding = ActivityLengthBinding.inflate(getLayoutInflater());

        setContentView(lengthBinding.getRoot());
        getSupportActionBar().setTitle("Length Convertor");


        // first Spinner Drop down elements
        List<String> firstSpinnerData = new ArrayList<String>();
        firstSpinnerData.add(a);
        firstSpinnerData.add(b);
        firstSpinnerData.add(c);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, firstSpinnerData);
        firstSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        lengthBinding.firstSpinner.setAdapter(firstSpinnerAdapter);
        //first spinner ends

        //second spinner funciton

        List<String> secondSpinnerData = new ArrayList<String>();

        secondSpinnerData.add(a);
        secondSpinnerData.add(b);
        secondSpinnerData.add(c);
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secondSpinnerData);
        secondSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthBinding.secondSpinner.setAdapter(secondSpinnerAdapter);
        firstSSData =  lengthBinding.firstSpinner.getSelectedItem().toString();
        secondSSData = lengthBinding.secondSpinner.getSelectedItem().toString();
        // second spinner ends here


        //selection part start here
        lengthBinding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                secondSSData =  adapterView.getSelectedItem().toString();
                if(!lengthBinding.secondEdittext.getText().toString().isEmpty()){
                    lengthBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lengthBinding.secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstSSData =  adapterView.getSelectedItem().toString();
                if(!lengthBinding.secondEdittext.getText().toString().isEmpty()){
                    lengthBinding.convertButton.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // selection part end here


        lengthBinding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double get_first_num = Double.parseDouble(lengthBinding.secondEdittext.getText().toString());

                if(firstSSData ==a && secondSSData==a){

                    lengthBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==a && secondSSData==b){

                    get_first_num =  1000*get_first_num;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));


                }else if (firstSSData ==a && secondSSData==c){

                    get_first_num =  1000*100*get_first_num;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b&& secondSSData==a){
                    get_first_num =  get_first_num/ 1000;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b && secondSSData==b){

                    get_first_num =  get_first_num;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==b && secondSSData==c){
                    get_first_num =  get_first_num * 100;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==c && secondSSData==a){
                    get_first_num =  (get_first_num/1000)/100;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));
                }else if(firstSSData ==c && secondSSData==b){
                    get_first_num =  get_first_num/100;
                    lengthBinding.firstText.setText(Double.toString(get_first_num));

                }else if(firstSSData ==c && secondSSData==c){
                    get_first_num =  get_first_num;

                    lengthBinding.firstText.setText(Double.toString(get_first_num));
                }


            }
        });



    }
}