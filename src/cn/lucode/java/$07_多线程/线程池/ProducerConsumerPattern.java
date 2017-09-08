package cn.lucode.java.$07_多线程.线程池;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lucode on 2017/7/8.
 */
public class ProducerConsumerPattern {
    public static void main(String args[]){

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }
}
//Producer Class in java  生产者
class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//Consumer Class in Java  消费者
class Consumer implements Runnable{

    private final BlockingQueue sharedQueue;

    public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(!sharedQueue.isEmpty()){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("推出");
    }

}
