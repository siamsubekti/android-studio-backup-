package com.enigma.android.questionlevelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InputUser extends AppCompatActivity {

    Button btnSubmitUser;

    EditText etNameIn;

    Spinner spinUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);

        btnSubmitUser = findViewById(R.id.btn_submit_name);
        etNameIn = findViewById(R.id.et_name);
        spinUser = findViewById(R.id.spinner_gender);

        btnSubmitUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = etNameIn.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name",s);
                intent.putExtra("spinner", spinUser.getSelectedItem().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
