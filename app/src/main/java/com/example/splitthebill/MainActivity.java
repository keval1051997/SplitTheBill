package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double totalAmountOfBill;
    int numberOfpeople;
    double totalTip;
    double individualShare;
    String chooseRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText amount = (EditText)findViewById(R.id.txtAmount);
        final EditText people = (EditText)findViewById(R.id.txtPeople);
        final Spinner rating = (Spinner)findViewById(R.id.txtRating);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView tip = ((TextView)findViewById(R.id.txtTip));
            final TextView share = ((TextView)findViewById(R.id.txtShare));

            @Override
            public void onClick(View v) {
                totalAmountOfBill = Double.parseDouble(amount.getText().toString( ));
                numberOfpeople = Integer.parseInt(people.getText( ).toString( ));
                totalTip = totalAmountOfBill * 0.18;

                DecimalFormat currency = new DecimalFormat("$###,###.###");
                individualShare = (totalAmountOfBill+totalTip)/ numberOfpeople;
                DecimalFormat currency1 = new DecimalFormat("$###,###.###");
                chooseRating= rating.getSelectedItem( ).toString( );
                tip.setText("Tip: " + currency.format(totalTip));
                share.setText("Your individual share is " +currency.format(individualShare));






            }
        });
    }
}
