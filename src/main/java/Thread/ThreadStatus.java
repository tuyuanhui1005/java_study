package Thread;

/**
 * 五大状态 创建状态  [new Thread() ]  就绪状态 [  .start()  ]  阻塞状态 [   .sleep()  ]  运行状态   死亡状态
 */
public class ThreadStatus {


    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("==================");

            }
        });

        Thread.State state = thread.getState();
        System.out.println("new Thread:" + state);

        thread.start();
        state = thread.getState();
        System.out.println(" thread.start()" + state);

        while (state != Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();
            System.out.println(state);
        }


    }
}
