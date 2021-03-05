package BlockingQueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread( () -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                synchronousQueue.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();


        new Thread( () -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t take 1");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }
}
