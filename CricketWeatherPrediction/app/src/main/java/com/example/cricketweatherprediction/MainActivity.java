package com.example.cricketweatherprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editInput;
    Button buttonSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput = findViewById(R.id.editInput);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        editInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                editInput.setHint("");
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredNumber = editInput.getText().toString().trim();

                if (enteredNumber.length() == 0)
                {
                    tvResult.setText("Enter a valid number");

                }
                else
                {
                    int number = Integer.parseInt(enteredNumber);

                    int calculation = (number / 3) + 4;

                    String output = calculation + "° C";

                    tvResult.setText(output);

                }
                tvResult.setVisibility(View.VISIBLE);

            }
        });

    }
}
