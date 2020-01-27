package com.example.pazlle15.presenters;

import com.example.pazlle15.contracts.Contract;
import com.example.pazlle15.models.Cordinate;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Presenter implements Contract.Presenter {
    private Contract.Model model;
    private Contract.View view;
    private Cordinate space;
    private int score;

    public Presenter(Contract.View view, Contract.Model model) {
        this.model = model;
        this.view = view;
        restart();
    }


    @Override
    public void restart() {
        score = 0;
        view.setScore(score);
        view.startTimer();
        space = new Cordinate(3, 3);
        view.loadData();

    }

    @Override
    public void finish() {
        view.finish();

    }

    @Override
    public void click(Cordinate cordinate) {
        int x = abs(cordinate.getX() - space.getX());
        int y = abs(cordinate.getY() - space.getY());
        if (x + y == 1) {
            view.setScore(++score);
            view.setElementText(space, view.getElementText(cordinate));
            view.setBackground(space);
            view.clearBackground(cordinate);
            view.setElementText(cordinate, "");
            space = cordinate;
            if (isWin()) {
                view.showWin();
            }
        }

    }

    private boolean isWin() {
        if (!(space.getY() == 3 && space.getX() == 3)) {
            return false;
        }
        for (int i = 0; i < 15; i++) {
            if (!view.getElementText(new Cordinate(i / 4, i % 4)).equals(String.valueOf(i + 1))) {
                return false;
            }
        }
        return true;

    }
}
