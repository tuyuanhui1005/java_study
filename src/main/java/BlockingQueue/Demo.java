package BlockingQueue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        System.out.println(blockingQueue.element());//检查队首元素


    }


}
