package com.numhero.client.widget;


import com.google.gwt.user.client.Timer;

public abstract class DelayedRunnable implements CoreConstants {

    private Timer timer = new Timer() {
        public void run() {
            DelayedRunnable.this.run();
        }
    };

    public DelayedRunnable() {
        this(DEFAULT_DELAY_MILLIS);
    }

    public DelayedRunnable(int delayMillis) {
        timer.schedule(delayMillis);
    }

    public abstract void run();

    public void cancel() {
        timer.cancel();
    }

}
