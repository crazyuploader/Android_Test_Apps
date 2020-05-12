package com.github.crazyuploader.randomdicegenerator;

import android.os.AsyncTask;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnInput;
    TextView tvResult, tvWait;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnInput = findViewById(R.id.btnInput);
        tvResult = findViewById(R.id.tvResult);
        tvWait = findViewById(R.id.tvWait);
        progressBar = findViewById(R.id.progressBar);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etInput.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter something!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    long noOfTimes = Integer.parseInt(etInput.getText().toString().trim());
                    new processInBackground().execute(noOfTimes);
                }
            }
        });
    }

    private class processInBackground extends AsyncTask<Long, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvResult.setVisibility(View.GONE);
            tvWait.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Long... longs) {

            int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, randomNumber;

            Random random = new Random();

            String results;

            for (int i = 0; i < longs[0]; i++)
            {

                randomNumber = random.nextInt(6) + 1;

                switch (randomNumber){
                    case 1:
                        one++;
                        break;

                    case 2:
                        two++;
                        break;

                    case 3:
                        three++;
                        break;

                    case 4:
                        four++;
                        break;

                    case 5:
                        five++;
                        break;

                    default:
                        six++;
                        break;
                }
            }

            results = "Results\n" + "One: " + one + "\nTwo: " + two + "\nThree: " + three + "\nFour: " + four + "\nFive: " + five + "\nSix: " + six;

            return results;
        }

        @Override
        protected void onPostExecute(String s) {

            tvWait.setVisibility(View.GONE);

            progressBar.setVisibility(View.GONE);

            tvResult.setText(s);

            tvResult.setVisibility(View.VISIBLE);

            Toast.makeText(MainActivity.this, "Process Done!", 0).show();

            super.onPostExecute(s);
        }
    }

}
