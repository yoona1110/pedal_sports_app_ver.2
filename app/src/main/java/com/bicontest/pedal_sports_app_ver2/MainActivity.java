package com.bicontest.pedal_sports_app_ver2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bicontest.pedal_sports_app_ver2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding; // view binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
    }
}