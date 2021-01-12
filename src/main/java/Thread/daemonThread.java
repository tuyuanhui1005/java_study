package Thread;

/**
 * 线程分为用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不需等待守护线程执行完毕
 */
public class daemonThread {

    public static void main(String[] args) {
        god god = new god();
        you you = new you();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认为false 一般都为用户线程
        thread.start();

        Thread thread1 = new Thread(you);
        thread1.start();



    }
}

class you implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("每一天开心的活着");
        }
        System.out.println("good bye world!");
    }
}

class  god implements  Runnable{
    @Override
    public void run() {
        while (true){

            System.out.println("上帝保佑着你！");
        }
    }
}
