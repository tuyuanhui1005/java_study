package Thread;

public class race implements Runnable {


    private static String winner;


    public static void main(String[] args) {

        race race = new race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameOver(i);
            if(flag) break;
            System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "步");

        }
    }

    public  Boolean  gameOver(int steps){
        if(winner!=null){
            return  true;
        }else {
            if(steps>=100){
                winner =  Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return  true;
            }
        }
        return  false;
    }
}
