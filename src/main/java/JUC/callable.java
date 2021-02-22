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

        MyCallable callable = new MyCallable();

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
//         new Thread( () ->{
//
//         },"a").start();

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();//调用的同一个对象

        System.out.println(futureTask.get());


        ArrayList arrayList = new ArrayList();



    }
}


class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("*************** come in ");
        return 1024;
    }
}
