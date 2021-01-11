package Thread;

public class StopThread implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run.............Thread" + i++);
        }

    }

    public void stop() {

        this.flag = false;
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        new Thread(stopThread).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                stopThread.stop();
                System.out.println("该线程停止了.........");
            }


        }

    }
}
