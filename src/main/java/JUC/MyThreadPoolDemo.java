package JUC;

import java.security.PublicKey;
import java.util.PrimitiveIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {

    private static  boolean flag = false;

    /**
     *   public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue) {
     *         this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
     *              Executors.defaultThreadFactory(), defaultHandler);
     *     }
     *
     *
     *
     *
     *      public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue,
     *                               ThreadFactory threadFactory,
     *                               RejectedExecutionHandler handler)
     *
     *
     *          corePoolSize ：线程池中常驻核心参数
     *          maximumPoolSize： 线程池最大线程数
     *          keepAliveTime： 多余的线程的存活时间
     *          unit：设置存活时间的单位
     *          workQueue：阻塞队列    当访问线程超过常驻线程时  都会存在 workQueue 中  用于传输和保存等待执行任务的阻塞队列
     *          ThreadFactory：threadFactory（线程工厂）：用于创建新线程。threadFactory创建的线程也是采用new Thread()方式，
     *                          threadFactory创建的线程名都具有统一的风格：pool-m-thread-n（m为线程池的编号，n为线程池内的线程编号）。
     *
     *          handler： 拒绝策略
     * @param args
     */


    public static void main(String[] args) {



         ExecutorService ThreadPool = Executors.newFixedThreadPool(3); //固定线程池
        //  ExecutorService ThreadPool = Executors.newSingleThreadExecutor(); //单线程池
        //ExecutorService ThreadPool = Executors.newCachedThreadPool();  //容量不固定，根据情况来决定大小


        try {
            for (int i = 0; i < 10; i++) {
                ThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 正在处理业务！");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ThreadPool.shutdown();
        }



    }




}
