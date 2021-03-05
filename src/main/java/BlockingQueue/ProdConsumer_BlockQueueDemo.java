package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumer_BlockQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);

        MyResource my = new MyResource(bq);
        new Thread(() -> {
            System.out.println("生产线程启动");
            try {
                my.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println("消费线程启动");
            try {
                my.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        TimeUnit.SECONDS.sleep(5L);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟后，main线程叫停，");
        my.stop();
    }


}

class MyResource {

    private volatile boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();


    BlockingQueue<String> blockingQeque = null;

    public MyResource(BlockingQueue<String> blockingQeque) {
        this.blockingQeque = blockingQeque;
        System.out.println(blockingQeque.getClass().getName());
    }

    public void stop() {
        this.flag = false;
    }
    public void myProd() throws Exception {
        String data = null;
        boolean resValue = true;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            resValue = blockingQeque.offer(data, 2L, TimeUnit.SECONDS);
            if (resValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败 ");
            }
            TimeUnit.SECONDS.sleep(1L);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了，表示flag = false，生产动作结束！");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (flag) {
            result = blockingQeque.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到值，消费退出！");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列" + result + "成功");
        }
    }
}
