package com.ankidroid.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView res;
    Spinner resSpin,inSpin;
    Button butt;
    EditText input;

    ArrayList<String> arrIDs = new ArrayList<>();//Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = findViewById(R.id.res);
        resSpin = findViewById(R.id.resSpin);
        inSpin = findViewById(R.id.inSpin);
        butt = findViewById(R.id.butt);
        input = findViewById(R.id.input);

        arrIDs.add("Celsius");
        arrIDs.add("Fahrenheit");
        arrIDs.add("Kelvin");


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrIDs);
        inSpin.setAdapter(spinnerAdapter);

        resSpin.setAdapter(spinnerAdapter);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x = Double.parseDouble(input.getText().toString());
                int selected1 = inSpin.getSelectedItemPosition();
                int selected2 = resSpin.getSelectedItemPosition();

                if(selected1 == selected2){
                    res.setText(Double.toString(x));
                }

                else if(selected1 == 0) {
                    if(selected2 == 1) {
                        double y = (x * 9 / 5) + 32;
                        res.setText(Double.toString(y));
                    }
                    else {
                        double y = x + 273.15;
                        res.setText(Double.toString(y));
                    }
                }

                else if (selected1 == 1) {
                    if(selected2 == 0){
                        double y = (x - 32) * 5/9;
                        res.setText(Double.toString(y));
                    }
                    else{
                        double y = ((x - 32) * 5/9) + 273.15;
                        res.setText(Double.toString(y));
                    }
                }
                else{
                    double y = x - 273.15;
                    if(selected2 == 0){
                        res.setText(Double.toString(y));
                    }
                    else{
                        y = (y * 9/5) + 32;
                        res.setText(Double.toString(y));
                    }
                }
            }
        });

    }
}