package BlockingQueue;

import java.nio.channels.Pipe;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {

//        test data = new test();
        ShareData data = new ShareData();

        new Thread(() -> {


            try {
                for (int i = 0; i < 5; i++) {
                    data.increment();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    data.decrement();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "B").start();

    }
}

class ShareData {

    private int numb = 0;
    private Lock lock = new ReentrantLock();
    private Condition Condition = lock.newCondition();
    public void increment() throws Exception {
        lock.lock();
        try {
            while (numb != 0) {
                Condition.await();
            }
            numb++;
            System.out.println(Thread.currentThread().getName() + "\t" + numb);
            Condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            while (numb == 0) {
                Condition.await();
            }
            numb--;
            System.out.println(Thread.currentThread().getName() + "\t" + numb);
            Condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


class  test{
    private  int numb= 0;
    public  synchronized  void  increment() throws InterruptedException {
         while ( numb != 0){
             wait();
         }
         numb++;
        System.out.println(Thread.currentThread().getName() + "\t" + numb);
         notifyAll();
    }

    public  synchronized  void  decrement() throws  Exception{
        while (numb == 0){
            wait();
        }
        numb--;
        System.out.println(Thread.currentThread().getName() + "\t" + numb);
        notifyAll();
    }
}
