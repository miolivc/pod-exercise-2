/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    private volatile int x = 0, y = 0;
    private ThreadA threadA;

    private void sum() {

        x = y + 1;
        y = x + 1;

    }

    private void buildThreads() {

        threadA = new ThreadA();

    }

    private void startThreads() throws InterruptedException {

        threadA.start();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) throws InterruptedException {

        Loader loader = new Loader();

        for (int i = 0; i < 10; i++) {

            loader.buildThreads();

            loader.startThreads();
        }

        Thread.sleep(3000);
        System.out.println(loader.getX());

    }

    public class ThreadA extends Thread {

        ThreadB threadB = new ThreadB();

        @Override
        public void run() {

            threadB.start();

            synchronized (threadB) {
                try {
                    threadB.wait();
                    sum();
                    System.out.println("A");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public class ThreadB extends Thread {

        @Override
        public void run() {

            synchronized (this) {
                sum();
                System.out.println("B");
                notify();
            }

        }

    }

}
