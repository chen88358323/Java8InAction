package org.cc.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : AtomicInteger
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-19 17:39
 */
public class AtomicIntegerDemo {
    private  static AtomicInteger sum3=new AtomicInteger(0);
    private  static int sum1=0;
    public static void main(String[] args) throws InterruptedException {

        test1();
        test2();
        test3();
    }

//    县城不安全的
    private  static void test1()throws InterruptedException{
        Thread[] ts=new Thread[90];
        CountDownLatch latch=new CountDownLatch(ts.length);
        for (int i = 0; i < ts.length; i++) {

            ts[i]=new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    sum1++;
                }
                latch.countDown();
            });
        }
        Arrays.stream(ts).forEach((t)->t.start());
        latch.await();
        System.out.println("test:"+sum1);
    }

    //    县城不安全的
    private  static void test2() throws InterruptedException{
        sum1=0;
        Object o=new Object();
        Thread[] ts=new Thread[90];
        CountDownLatch latch=new CountDownLatch(ts.length);
        for (int i = 0; i < ts.length; i++) {

            ts[i]=new Thread(()->{
                synchronized (o){

                    for (int j = 0; j < 1000; j++) {
                        sum1++;
                    }
                    latch.countDown();
                }
            });
        }
        Arrays.stream(ts).forEach((t)->t.start());
        latch.await();
        System.out.println("test2:"+sum1);
    }


    private  static void test3()throws InterruptedException{
        Thread[] ts=new Thread[90];
        CountDownLatch latch=new CountDownLatch(ts.length);
        for (int i = 0; i < ts.length; i++) {

            ts[i]=new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    sum3.incrementAndGet();
                }
                latch.countDown();
            });
        }
        Arrays.stream(ts).forEach((t)->t.start());
        latch.await();
        System.out.println("test3:"+sum3);
    }
}