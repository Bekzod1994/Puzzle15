package com.example.pazlle15.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.pazlle15.contracts.Contract;
import com.example.pazlle15.models.Cordinate;
import com.example.pazlle15.models.Model;
import com.example.pazlle15.presenters.Presenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private Presenter presenter;
    private Model model;
    private TextView score;
    private Chronometer chronometer;
    private Button[][] buttons;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Model();
        buttons = new Button[4][4];
        chronometer = new Chronometer(this);
        loadViews();
        presenter = new Presenter(this, model);
        Log.d("TTT","salom");
    }


    @Override
    public void loadData() {
        ArrayList data= model.getData();
        for (int i = 0; i <data.size() ; i++) {
            buttons[i / 4][i % 4].setText(data.get(i).toString());
            buttons[i / 4][i % 4].setBackgroundResource(R.drawable.bt_bakc);
            buttons[3][3].setBackgroundResource(R.drawable.empty_button);

        }


    }


    @Override
    public void setElementText(Cordinate coordinate, String s) {
        buttons[coordinate.getX()][coordinate.getY()].setText(s);

    }
    private void loadViews(){chronometer = findViewById(R.id.time);
        score = findViewById(R.id.score);
        Button finish = findViewById(R.id.finish);
        finish.setOnClickListener(view -> presenter.finish());
        findViewById(R.id.restart).setOnClickListener(view -> presenter.restart());
        relativeLayout = findViewById(R.id.relativeLayout);
        for (int i = 0; i < relativeLayout.getChildCount(); i++) {
            Button button = (Button) relativeLayout.getChildAt(i);
            buttons[i / 4][i % 4]= button;
            button.setTag(new Cordinate(i/4,i%4));
            button.setOnClickListener(view -> presenter.click((Cordinate) view.getTag()));
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==2){
            finish();
        }else if (resultCode == 3){
            presenter.restart();
        }
    }

    @Override
    public void setScore(int score) {
        this.score.setText(score + "");


    }

    @Override
    public void showWin() {
        Intent intent = new Intent(this,WinActivity.class);
        intent.putExtra("score",score.getText());
        intent.putExtra("timer",chronometer.getText());
        startActivityForResult(intent,100);


    }

    @Override
    public void startTimer() {
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

    }

    @Override
    public void setBackground(Cordinate coordinate) {
        buttons[coordinate.getX()][coordinate.getY()].setBackgroundResource(R.drawable.bt_bakc);

    }

    @Override
    public void clearBackground(Cordinate coordinate) {
        buttons[coordinate.getX()][coordinate.getY()].setBackgroundResource(R.drawable.empty_button);
    }

    @Override
    public String getElementText(Cordinate coordinate) {
        return buttons[coordinate.getX()][coordinate.getY()].getText().toString();
    }
}
