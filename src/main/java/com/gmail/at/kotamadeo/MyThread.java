package com.gmail.at.kotamadeo;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {
    private final long seconds;

    public MyThread(long seconds) {

        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.printf("Я - %s. Всем привет!%n", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(seconds);
            }
        } catch (InterruptedException ignored) {
        } finally {
            System.out.printf("%s завершен%n", getName());
        }
    }
}
