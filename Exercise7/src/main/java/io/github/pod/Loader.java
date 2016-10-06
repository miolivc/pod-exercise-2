/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    static int x = 0, y = 0;
    static Thread a, b;

    public synchronized static void sum() {

        x = y + 1;
        y = x + 1;

    }

    public static void buildThreads() {

        a = new Thread() {

            @Override
            public void run() {

                sum();

            }
        };

        b = new Thread() {

            @Override
            public void run() {

                sum();

            }
        };

    }
    
    public static void startThreads(){
        
        a.start();
        b.start();
        
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {

            buildThreads();
            
            startThreads();

        }
        
        Thread.sleep(3000);
        System.out.println(x);

    }

}
