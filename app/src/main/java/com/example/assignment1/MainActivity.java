package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText mPrinciple, mInterestRate, mYears;
    private TextView mMonthlyPayment, mTotalLeft;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrinciple = (EditText) findViewById(R.id.principle_amt);
        mInterestRate = (EditText)findViewById(R.id.interest_rt);
        mYears = (EditText)findViewById(R.id.years_amt);
        mMonthlyPayment = (TextView)findViewById(R.id.Amount);
        mTotalLeft = (TextView)findViewById(R.id.total_results);
    }
    public void CalculatedLoan(View clickedButton){

        double Principle = Double.parseDouble(mPrinciple.getText().toString());
        double InterestRate = (Double.parseDouble(mInterestRate.getText().toString()));
        double Years = Double.parseDouble(mYears.getText().toString());
        double n = Years * 12;

        double r = InterestRate/100/12;
        double r1 = Math.pow(r+1, -n);

        double Calculate = (Principle * r);
        Calculate /= (1 - r1);

        Double Totals = ((Calculate * n) - Principle) ;


        mMonthlyPayment.setText(new DecimalFormat("##.##").format(Calculate));
        mTotalLeft.setText(new DecimalFormat("##.##").format(Totals));






    }


}