package com.example.vectorbasedimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView viewImage;
    ImageView imageButtonHear, imageButtonBeach, imageButtonTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewImage = findViewById(R.id.viewImage);
        imageButtonBeach = findViewById(R.id.imageButtonBeach);
        imageButtonHear = findViewById(R.id.imageButtonHear);
        imageButtonTV = findViewById(R.id.imageButtonTV);

        imageButtonHear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage.setImageResource(R.drawable.hear);

            }
        });

        imageButtonBeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage.setImageResource(R.drawable.beach);
            }
        });

        imageButtonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage.setImageResource(R.drawable.tv);
            }
        });
    }
}
