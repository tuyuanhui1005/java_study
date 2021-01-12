package Thread;

public class joinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        joinThread joinThread = new joinThread();

        Thread thread = new Thread(joinThread);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                thread.join();

            }
            System.out.println("普通线程" + i);

        }
    }
}

