package com.example.task08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final Integer[] images = { R.drawable.sl190,
            R.drawable.sl280, R.drawable.sl300, R.drawable.sl350, R.drawable.sl500_1998, R.drawable.sl500,
            R.drawable.slr231, R.drawable.sl63};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}