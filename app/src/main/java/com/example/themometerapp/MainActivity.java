package com.example.themometerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton Celci_radiobtn;
    RadioButton Faren_radiobtn;
    Button btn_calc;
    TextView txtv_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        Celci_radiobtn = findViewById(R.id.Celci_radiobtn);
        Faren_radiobtn = findViewById(R.id.Faren_radiobtn);
        btn_calc = findViewById(R.id.btn_calc);
        txtv_result = findViewById(R.id.txtv_result);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){

        Calculations cal = new Calculations();

        String value = et_temp.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();
        }
        else{
            Float temp = Float.parseFloat(value);
            if(Celci_radiobtn.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if (Faren_radiobtn.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }
            else{
                Toast.makeText(this, "Select a button!", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }

            txtv_result.setText(new Float(temp).toString());

        }

    }


}