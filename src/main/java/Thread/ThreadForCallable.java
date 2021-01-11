package Thread;

import java.util.concurrent.*;

public class ThreadForCallable implements Callable {


    @Override
    public Object call() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadForCallable callable = new ThreadForCallable();

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result = service.submit(callable);
        //获取结果
        Boolean aBoolean = result.get();
        //关闭服务
        service.shutdownNow();



    }
}
