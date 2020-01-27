package com.example.pazlle15.contracts;

import com.example.pazlle15.models.Cordinate;

import java.util.ArrayList;
import java.util.List;

public interface Contract  {
    interface Model {
        ArrayList getData();

    }
    interface View{
        void showWin();
        void loadData();
        void finish();
        void setElementText(Cordinate coordinate, String s);
        void setScore(int score);
        void startTimer();
        void setBackground(Cordinate coordinate);
        void clearBackground(Cordinate coordinate);
        String getElementText(Cordinate coordinate);

    }
    interface Presenter{
        void restart();
        void finish();
        void click(Cordinate cordinate);

    }
}
