package com.example.pazlle15.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findViewById(R.id.play).setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivityForResult(intent,1);
        });
        findViewById(R.id.about).setOnClickListener(view -> {
            Intent intent = new Intent(this,AboutActivity.class);
            startActivityForResult(intent,200);
        });
        findViewById(R.id.exit).setOnClickListener(view -> {
            finish();
        });
    }
}
