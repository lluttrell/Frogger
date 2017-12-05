package frogger.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CountdownTimer is a count down timer that counts down from 30.
 */
public class CountdownTimer {
    private Timer timer;
    private int countDown = 30;

    /**
     * Constructor for CountdownTimer
     */
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

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }
}
