package Thread;

public class yieldThread {

    public static void main(String[] args) {
        myYield myYield = new myYield();
        myYield myYield1 = new myYield();

        new Thread(myYield,"a").start();
        new Thread(myYield1,"b").start();
    }
}


class   myYield  implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--线程开始执行");
      //   Thread.yield();//线程礼让
        System.out.println(Thread.currentThread().getName()+"--线程结束结束");
    }
}