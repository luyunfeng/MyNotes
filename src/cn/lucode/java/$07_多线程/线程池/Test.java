package cn.lucode.java.$07_多线程.线程池;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by lucode on 2017/5/14.
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            System.out.println(index);
                            Thread.sleep(10 * 1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    /*
    * 三个线程 循序打印 ABC
    * 解决思路
    * 1.线程池创建三个线程
    * 2.重写 run 方法
    * 3.设置标志位
    *
    * */

    Boolean printA = true;
    Boolean printB = false;
    Boolean printC = false;

    @org.junit.Test
    public void test() {

        ExecutorService pool = Executors.newFixedThreadPool(3);


        pool.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (Test.class) {
                        while (!printA) {
                            try {
                                Test.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        System.out.print("A");
                        printA = false;
                        printB = true;
                        printC = false;

                        Test.class.notifyAll();
                    }
                }
            }

        });


        pool.submit(new Runnable() {
            public void run() {

                for (int i = 0; i < 10; i++) {
                    synchronized (Test.class) {
                        while (!printB) {
                            try {
                                Test.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        System.out.print("B");
                        printA = false;
                        printB = false;
                        printC = true;
                        Test.class.notifyAll();
                    }
                }
            }

        });
        pool.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (Test.class) {
                        while (!printC) {
                            try {
                                Test.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("C");
                        printA = true;
                        printB = false;
                        printC = false;
                        Test.class.notifyAll();
                    }
                }
            }

        });

    }


    // 生产者消费者模式
    /*
    *   java中定义队列 一般这样定义： Queue<E> queue = new LinkedList<E>();
        当采用LinkedList来实现时，api的使用和对用关系如下：
        队列方法       等效方法
        offer(e)      offer(e)/offerLast(e)  //进队列，将元素加入队列末尾
        poll()        poll()/pollFirst()  //获取队列头的元素并移除
        peek()        peek()/peekFirst()  //获取队列头的元素
        isEmpty() //判断是否为空
    *
    * */
    @org.junit.Test
    public void test2(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.toString());

    }

    @org.junit.Test
    public void test3(){
        try {
            ThreadA t1 = new ThreadA("t1");
            ThreadA t2 = new ThreadA("t2");
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
    class ThreadA extends Thread{

        public ThreadA(String name){
            super(name);
        }
        public void run(){
            System.out.printf("%s start\n", this.getName());

            // 延时操作

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s finish\n", this.getName());
        }
    }



}




