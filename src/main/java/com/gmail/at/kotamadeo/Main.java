package com.gmail.at.kotamadeo;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MyThread firstThread = new MyThread(5);
        firstThread.setName("Первый поток");
        MyThread secondThread = new MyThread(5);
        secondThread.setName("Второй поток");
        MyThread thirdThread = new MyThread(5);
        thirdThread.setName("Третий поток");
        MyThread fourthThread = new MyThread(5);
        fourthThread.setName("Четвертый поток");
        threadRunner(firstThread, secondThread, thirdThread, fourthThread);
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException ignored) {
        } finally {
            threadStopper(firstThread, secondThread, thirdThread, fourthThread);
        }
    }

    private static void threadRunner(MyThread... threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }

    private static void threadStopper(MyThread... threads) {
        Arrays.stream(threads).forEach(Thread::interrupt);
    }
}