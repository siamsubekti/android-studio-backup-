package com.enigma.android.tebakwarna;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SeekBar skRed, skBlue, skGreen;
    TextView tvRed, tvRedNumber, tvBlue, tvBlueNumber, tvGreen, tvGreenNumber, tvPrencetage;
    LinearLayout bgColor1, bgColor2;
    Button btnGenerate, btnTebak;

    int baseRed = 0;
    int baseBlue = 0;
    int baseGreeen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skRed = findViewById(R.id.sk_red);
        skBlue = findViewById(R.id.sk_blue);
        skGreen = findViewById(R.id.sk_green);
        tvRed = findViewById(R.id.tv_red);
        tvRedNumber = findViewById(R.id.tv_red_angka);
        tvBlue = findViewById(R.id.tv_blue);
        tvBlueNumber = findViewById(R.id.tv_blue_angka);
        tvGreen = findViewById(R.id.tv_green);
        tvGreenNumber = findViewById(R.id.tv_green_angka);
        tvPrencetage = findViewById(R.id.tv_precentage);
        bgColor1 = findViewById(R.id.bg_color_1);
        bgColor2 = findViewById(R.id.bg_color2);
        btnGenerate = findViewById(R.id.btn_generate_color);
        btnTebak = findViewById(R.id.btn_tebak);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                baseRed = random.nextInt(256);
                baseBlue = random.nextInt(256);
                baseGreeen = random.nextInt(256);
                int color = Color.argb(255,baseRed, baseBlue, baseGreeen);
                bgColor1.setBackgroundColor(color);
            }
        });

        btnTebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer red = Integer.parseInt(tvRedNumber.getText().toString());
                Integer blue = Integer.parseInt(tvBlueNumber.getText().toString());
                Integer green = Integer.parseInt(tvGreenNumber.getText().toString());
                tvPrencetage.setText(Math.addExact(red,blue);
            }
        });

        skRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = 256;
                bgColor2.setBackgroundColor(Color.rgb(skRed.getProgress(), skBlue.getProgress(), skGreen.getProgress()));
//                skRed.setProgress(256);
                tvRedNumber.setText(""+ skRed.getProgress()+"/"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = 256;
                bgColor2.setBackgroundColor(Color.rgb(skRed.getProgress(), skBlue.getProgress(), skGreen.getProgress()));
                tvBlueNumber.setText("" + skBlue.getProgress() + "/" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = 256;
                bgColor2.setBackgroundColor(Color.rgb(skRed.getProgress(), skBlue.getProgress(), skGreen.getProgress()));
                tvGreenNumber.setText("" + skGreen.getProgress() + "/" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_generate_color :
                break;
            case  R.id.btn_tebak :
                break;
        }
    }
}
