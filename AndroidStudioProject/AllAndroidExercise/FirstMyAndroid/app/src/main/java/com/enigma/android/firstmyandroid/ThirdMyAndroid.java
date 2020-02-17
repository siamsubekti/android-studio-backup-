package com.enigma.android.firstmyandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.enigma.android.firstmyandroid.com.enigma.android.menu.Menu1;
import com.enigma.android.firstmyandroid.com.enigma.android.menu.Menu2;

public class ThirdMyAndroid extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_my_android);

        TextView tvThird = findViewById(R.id.tv_third);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        Integer age = getIntent().getIntExtra(EXTRA_AGE, 0);
        String text = "Name : " + name + ",\nYour Age : "+ age;
        tvThird.setText(text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_1) {
            startActivity(new Intent(this, Menu1.class));
        } else if (item.getItemId() == R.id.menu_2) {
            startActivity(new Intent(this, Menu2.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
