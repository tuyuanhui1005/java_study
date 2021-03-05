package JUC;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;


/**
 * get 方法一般放在最后一行
 * get  是阻塞方法
 */
public class callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable callable = new MyCallable(1, 1000);
        MyCallable callable1 = new MyCallable(1001, 2000);
        MyCallable callable2 = new MyCallable(2001, 3000);
        MyCallable callable3 = new MyCallable(3001, 4000);

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        FutureTask<Integer> futureTask1 = new FutureTask<>(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable2);
        FutureTask<Integer> futureTask3 = new FutureTask<>(callable3);
        new Thread(futureTask, "A").start();
        new Thread(futureTask1, "B").start();//调用的同一个对象
        new Thread(futureTask2, "C").start();//调用的同一个对象
        new Thread(futureTask3, "D").start();//调用的同一个对象
        System.out.println(futureTask.get() + futureTask1.get() + futureTask2.get() + futureTask3.get());
        int sum = 0;
        for (int i = 0; i <= 4000; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}


class MyCallable implements Callable<Integer> {

    private int start;
    private int end;
    private int result = 0;

    public MyCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = start; i <= end; i++) {
            result += i;
        }
        return result;
    }
}
