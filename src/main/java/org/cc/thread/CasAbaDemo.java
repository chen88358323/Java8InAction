package org.cc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName : CasAbaDemo
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-23 21:18
 *
 * https://blog.csdn.net/MonkeyBrothers/article/details/113102271
 */
public class CasAbaDemo {

        private final static AtomicInteger num = new AtomicInteger(100);
    private final static AtomicStampedReference<Integer> stamp = new AtomicStampedReference<>(100, 1);
        public static void main(String[] args)  throws InterruptedException{
            CasAbaDemo  cad=new CasAbaDemo();
//            cad.test1();
            cad.testABAVersion();
        }
        private void testABAVersion(){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 第1次版本号:" + stamp.getStamp()+"  val"+stamp.getReference());
                stamp.compareAndSet(100, 200, stamp.getStamp(), stamp.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + " 第2次版本号:" + stamp.getStamp()+"  val"+stamp.getReference());
                stamp.compareAndSet(200, 100, stamp.getStamp(), stamp.getStamp() + 1);//为什么这句话，值没有变？
                System.out.println(Thread.currentThread().getName() + " 第2次版本号:" + stamp.getStamp()+"  val"+stamp.getReference());
            }).start();

            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " 第1次版本号:" + stamp.getStamp()+"  val"+stamp.getReference());
                    stamp.compareAndSet(100, 400, stamp.getStamp(), stamp.getStamp() + 1);
                    System.out.println(Thread.currentThread().getName() + " 获取到的值：" + stamp.getReference());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //it's aba
        private  void test1() throws InterruptedException {
            new Thread(() -> {
                num.compareAndSet(100, 101);
                System.out.println(Thread.currentThread().getName() + " 修改num之后的值：" + num.get());
            }).start();
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    num.compareAndSet(101, 100);
                    System.out.println(Thread.currentThread().getName() + " 修改num之后的值：" + num.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(4);
                    num.compareAndSet(100, 200);
                    System.out.println(Thread.currentThread().getName() + " 修改num之后的值：" + num.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
