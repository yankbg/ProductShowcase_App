package com.example.task08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final Integer[] images = { R.drawable.straw,
            R.drawable.banana, R.drawable.orange, R.drawable.mango, R.drawable.apple, R.drawable.watermelon,
            R.drawable.grape, R.drawable.pineapple};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}