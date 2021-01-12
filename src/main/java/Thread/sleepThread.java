package Thread;

import java.util.Date;
import java.util.logging.SimpleFormatter;

public class sleepThread implements Runnable {

    public void run() {

    }

    public static void tenDown() throws InterruptedException {
        int numb = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(numb--);
            if (numb <= 0) break;
            ;
        }
    }

    public static void main(String[] args) {

        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
