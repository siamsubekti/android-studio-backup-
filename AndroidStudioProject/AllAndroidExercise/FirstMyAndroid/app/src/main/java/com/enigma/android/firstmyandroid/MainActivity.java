package com.enigma.android.firstmyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etStartPoint;
    TextView etNol;
    Button btnStartSubmit, btnPlus, btnMinus, btnClear, btnMoveActivity, btnMoveActivityData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStartPoint = findViewById(R.id.etStartPoint);
        etNol = findViewById(R.id.etNol);
        btnStartSubmit = findViewById(R.id.btnSubmitStart);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnClear = findViewById(R.id.btnClear);
        btnMoveActivity = findViewById(R.id.move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveActivityData = findViewById(R.id.move_activity_data);
        btnMoveActivityData.setOnClickListener(this);
    }

    public void submitStartPoint(View view){
        etNol.setText(etStartPoint.getText());
    }

    public void increment(View view) {

            Integer increment = Integer.parseInt(etNol.getText().toString());
            etNol.setText(String.valueOf(increment + 1));
    }

    public void decrement(View view){
        Integer decrement = Integer.parseInt(etNol.getText().toString());
        etNol.setText(String.valueOf(decrement-1));
    }

    public void clear(View view){
        etNol.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.move_activity :
                Intent moveIntentImplisit = new Intent(MainActivity.this, SecondMyAndroid.class);
                startActivity(moveIntentImplisit);
                break;
            case R.id.move_activity_data :
                Intent moveData = new Intent(MainActivity.this, ThirdMyAndroid.class);
                moveData.putExtra(ThirdMyAndroid.EXTRA_NAME, "Name");
                moveData.putExtra(ThirdMyAndroid.EXTRA_AGE, 22);
                startActivity(moveData);
                break;
        }
    }
}
