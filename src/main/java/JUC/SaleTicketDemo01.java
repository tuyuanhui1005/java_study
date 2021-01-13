package JUC;


import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个售票员卖票
 * 在高内聚低耦合的前提下 ： ===》 线程 操作  资源类
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {//主线程 一切程序的入口

        Ticket ticket = new Ticket();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"小明");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"小图");
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"小王");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Ticket {
    private int numb = 30;

    //  List  list = new ArrayList()
    ReentrantLock lock = new ReentrantLock();
    public void sale() {

        lock.lock();

        try {
            if (numb > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (numb--) + "\t还剩下：" + numb);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}
