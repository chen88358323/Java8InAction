package org.cc.thread.reentantlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier {
    public static void main(String[] args) {
        //CyclicBarrier barrier = new CyclicBarrier(20);

//        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人，发车"));

        /**/
        CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人，发车");
            }
        });

        for(int i=0; i<100; i++) {

                new Thread(()->{
                    try {
                        System.out.println(Thread.currentThread().getName()+"isdone");
                        barrier.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
            
        }
    }
}
