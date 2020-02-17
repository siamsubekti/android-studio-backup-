package com.enigma.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SecondActivity extends AppCompatActivity {
    int counter = 1;
    Button btnNext, btnBack;
    ImageView image;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnNext = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.btn_back);
        image = findViewById(R.id.img_view);
        textResult = findViewById(R.id.tv_result);

    }

    public void street(View view) {
        if (counter == 1) {
            switch (view.getId()) {
                case R.id.btn_back :
                    image.setImageResource(R.drawable.ocean);
                    textResult.setText("Ocean");
                    counter+=1;
                    break;
                case R.id.btn_next :
                    image.setImageResource(R.drawable.montain);
                    textResult.setText("Mountain");
                    counter+=2;
                    break;
            }
        } else if (counter == 2) {
            switch (view.getId()) {
                case R.id.btn_back :
                    image.setImageResource(R.drawable.abyss);
                    textResult.setText("Abyys");
                    counter = 0;
                case R.id.btn_next :
                    image.setImageResource(R.drawable.waterfall);
                    textResult.setText("Waterfall");
                    counter+=1;
            }
        }
    }

//    public List<Place> getAllPlace() {
//        List<Place> placeList = new ArrayList<>();
//        Place place = new Place();
//        place.setID();
//    }
}
