package BlockingQueue;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronousAndReenterLock {

    public static void main(String[] args) {

    }

    public void test() {

        synchronized (new Object()) {


        }

        ReentrantLock reentrantLock = new ReentrantLock();
    }


}
