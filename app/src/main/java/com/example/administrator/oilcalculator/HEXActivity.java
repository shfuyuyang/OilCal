package com.example.administrator.oilcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class HEXActivity extends ActionBarActivity {

    EditText editTextT50;
    EditText editTextP20;
    EditText editTextResult;
    Button buttonHexCalculate;

    double t50 = 0;
    double p20 = 0;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex);

        editTextT50 = (EditText) findViewById(R.id.editTextT50);
        editTextP20 = (EditText) findViewById(R.id.editTextP20);
        editTextResult=(EditText)findViewById(R.id.editTextResult);

        buttonHexCalculate = (Button) findViewById(R.id.buttonHEXCalculate);

        buttonHexCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t50=Double.parseDouble(editTextT50.getText().toString());
                p20=Double.parseDouble(editTextP20.getText().toString());

                result=HEXCalculate(t50,p20);

                editTextResult.setText(""+result);
            }
        });

    }

    double HEXCalculate(double t50, double p20) {
        double res = 0;
        res = 431.29 - 1586.88 * p20 + 730.97 * Math.pow(p20, 2) + 12.392 * Math.pow(p20, 3) + 0.0515 * Math.pow(p20, 4) - 0.554 * t50 + 97.803 * Math.pow((Math.log10(t50)), 2);
        return res;
    }

}
