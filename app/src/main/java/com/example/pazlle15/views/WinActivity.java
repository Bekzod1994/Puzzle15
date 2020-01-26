package com.example.pazlle15.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        Bundle bundle = getIntent().getExtras();
        TextView score = findViewById(R.id.score);
        TextView timer = findViewById(R.id.timer);
        if (bundle != null) {
            score.setText(String.format("Score: %s", bundle.getString("score")));
            timer.setText(String.format("Time: %s", bundle.getString("timer")));
        }
        findViewById(R.id.restartGame).setOnClickListener(view -> restart());
        findViewById(R.id.finishGame).setOnClickListener(view -> finishGame());
    }

    void finishGame() {
        setResult(2);
        finish();
    }

    void restart() {
        setResult(3);
        finish();
    }
}
