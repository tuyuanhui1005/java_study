package Thread;

public class TestThread2 implements Runnable {

    private int ticketNumb = 10;

    public void run() {
        while (true) {
            if (ticketNumb <= 0) break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--> 拿到了第" + ticketNumb-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread2 ticket = new TestThread2();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();

    }
}
