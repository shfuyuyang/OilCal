package com.example.administrator.oilcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class VIActivity extends ActionBarActivity {

    EditText editText40;
    EditText editText100;
    EditText editTextIndex;
    Button buttonCalculate;

    public double vi40 = 0;
    public double vi100 = 0;
    public int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi);

        editText40 = (EditText) findViewById(R.id.editTextVI40);
        editText100 = (EditText) findViewById(R.id.editTextVI100);
        editTextIndex = (EditText) findViewById(R.id.editTextVIndex);
        buttonCalculate = (Button) findViewById(R.id.buttonVICalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vi40 = 0;
                vi100 = 0;
                index = 0;

                vi40 = Double.parseDouble((editText40.getText().toString()));
                vi100 = Double.parseDouble((editText100.getText().toString()));

                index= (int) calculateVI(vi40,vi100);

                editTextIndex.setText(""+index);
            }
        });
    }

    double calculateVI(double v40, double v100) {
        double Q3=0, Q4=0, Q5=0, Q6=0, Q7=0;
        double Q2;
        double Q1;
        Q2 = v100;
        Q1 = v40;

        if (Q2 >= 2 && Q2 < 4) {
            Q3 = 0.827 * Math.pow(Q2, 2) + 1.632 * Q2 - 0.181;
            Q4 = 0.3094 * Math.pow(Q2, 2) + 0.182 * Q2;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 4 && Q2 < 6.1) {
            Q3 = -2.6758 * Math.pow(Q2, 2) + 96.671 * Q2 - 269.664 * Math.sqrt(Q2) + 215.025;
            Q4 = -7.1955 * Math.pow(Q2, 2) + 241.992 * Q2 - 725.478 * Math.sqrt(Q2) + 603.88;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 6.1 && Q2 < 7.2) {
            Q3 = 2.32 * Math.pow(Q2, 1.5626);
            Q4 = 2.838 * Math.pow(Q2, 2) - 27.35 * Q2 + 81.83;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 7.2 && Q2 < 12.4) {
            Q3 = 0.1922 * Math.pow(Q2, 2) + 8.25 * Q2 - 18.728;
            Q4 = 0.5463 * Math.pow(Q2, 2) + 2.442 * Q2 - 14.16;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 12.4 && Q2 <= 70.0) {
            Q3 = 1795.2 * Math.pow(Q2, (-2)) + 0.1818 * Math.pow(Q2, 2) + 10.357 * Q2 - 54.547;
            Q4 = 0.6995 * Math.pow(Q2, 2) - 1.19 * Q2 + 7.6;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 > 70) {
            Q3 = 0.1684 * Math.pow(Q2, 2) + 11.85 * Q2 - 97;
            Q5 = 0.8353 * Math.pow(Q2, 2) + 14.67 * Q2 - 216;
            Q4 = 0.6669 * Math.pow(Q2, 2) + 2.82 * Q2 - 119;
            Q6 = (Q5 - Q1) / Q4 * 100;
        }

        if (Q6 >= 100) {
            Q7 = ((Math.log(Q3) / Math.log(10)) - (Math.log(Q1) / Math.log(10))) / (Math.log(Q2) / Math.log(10));
            Q6 = ((Math.pow(10.0, Q7) - 1) / 0.00715) + 100.0;
        }
        return Q6 + 0.5;
    }

}
