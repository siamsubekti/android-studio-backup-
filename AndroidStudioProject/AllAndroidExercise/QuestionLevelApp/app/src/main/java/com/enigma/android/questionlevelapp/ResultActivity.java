package com.enigma.android.questionlevelapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {
    RatingBar bar;
    TextView textRating;
    Button btnBackToMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bar = findViewById(R.id.ratingBar1);
        textRating = findViewById(R.id.textResult);
        btnBackToMenu = findViewById(R.id.btn_back);

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");
        bar.setRating(score);

        switch (score) {
            case 1 :
            case 2 : textRating.setText("TRY AGAIN LATER, KEEP LEARNING");
            break;
            case 3 :
            case 4 : textRating.setText("YOU JUST NEED TO RE-READ IT AGAIN");
            break;
            case 5 : textRating.setText("CONGRATS");
            break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}
