package frogger.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownTimer {
    private Timer timer;
    private int countDown = 30;

    public CountdownTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countDown <= 0) {
                    ((Timer) e.getSource()).stop();
                    countDown = 30;
                } else {
                    countDown--;
                }
            }
        });
    }

    public void start() {
        timer.start();
    }

    public int getSecondsRemaining() {
        return countDown;
    }
}
