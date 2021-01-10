package Thread;


//实现runnable  接口  实现多线程
public class TestThread1 implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("多线程：" + i);
        }
    }


    public static void main(String[] args) {

        TestThread1 thread1 = new TestThread1();
        Thread t = new Thread(thread1);
        t.start();
        for (int j = 0; j < 20; j++) {
            System.out.println("主线程：" + j);
        }
    }
}
