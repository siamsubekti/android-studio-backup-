package com.enigma.android.questionlevelapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int SECOND_RESULT_CODE = 0;
    public static final int THIRD_RESULT_OK = 1;

    Button btnSubmitForUser, btnChallenge;
    TextView tvOutName, tvOutGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmitForUser = findViewById(R.id.btn_submit);
        tvOutName = findViewById(R.id.tv_name_out);
        tvOutGender = findViewById(R.id.tv_gender_out);
        btnChallenge = findViewById(R.id.btn_challenge);

        btnSubmitForUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent moveToUser = new Intent(MainActivity.this, InputUser.class);
                startActivityForResult(moveToUser, SECOND_RESULT_CODE);
            }
        });

        btnChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent moveToChallenge = new Intent(MainActivity.this, QuizActivity.class);
                startActivityForResult(moveToChallenge, THIRD_RESULT_OK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_RESULT_CODE ){
            if (resultCode == RESULT_OK){
                String getUser = data.getStringExtra("name");
                String getGenderUser = data.getStringExtra("spinner");
                tvOutName.setText(getUser);
                tvOutGender.setText(getGenderUser);
            }
        }
    }
}
