package com.example.magicid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editID;
    Button button_submit;
    TextView show_output;
    String Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editID = findViewById(R.id.editID);
        button_submit = findViewById(R.id.button_submit);
        show_output = findViewById(R.id.show_output);

        show_output.setVisibility(View.GONE);

        editID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                editID.setHint("");
            }
        });

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = editID.getText().toString().trim();

                if (idNumber.length() == 13)
                {
                    String dob = idNumber.substring(0, 6);

                    int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                    String sGender;

                    if (gender >= 5)
                        sGender = "Male";
                    else
                        sGender = "Female";

                    int nationality = Integer.parseInt(Character.toString(idNumber.charAt(11)));

                    String sNationality;

                    if (nationality == 0)
                        sNationality = "SA Citizen";
                    else
                        sNationality = "Permanent Resident";

                    Text = getString(R.string.dob) + ": " + dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" + dob.substring(4, 6) + "\n"
                            + getString(R.string.gender) + ": " + sGender + "\n"
                            + getString(R.string.nationality) + ": " + sNationality;

                    show_output.setText(Text);
                }
                else
                {
                    Text = "Not a Valid ID\n" + "A Valid ID is 13 Digits long";

                    show_output.setText(Text);
                }

                show_output.setVisibility(View.VISIBLE);
            }
        });
    }
}
