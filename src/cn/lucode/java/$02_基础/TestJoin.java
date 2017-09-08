package cn.lucode.java.$02_基础;

/**
 * Created by lucode on 2017/7/11.
 */

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");

        Thread t1 = new Thread(new Worker("thread-1"));
        Thread t2 = new Thread(new Worker("thread-2"));
        /*
        *
        * 这样写 就是让 两个线程并发执行，结束后再执行主线程 打印 end
        * */
        t1.start();
        t2.start();

        t1.join();
        t2.join();


        /* t1执行完之后 t2 才继续执行
        t1.start();
        t1.join();
        t2.start();
        t2.join();
         */

        System.out.println("main end");
    }
}

class Worker implements Runnable {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }

}

