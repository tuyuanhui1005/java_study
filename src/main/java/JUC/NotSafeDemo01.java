package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *   ArrayList 线程不安全
 *   故障现象
 *   java.util.ConcurrentModificationException
 *
 *   产生原因
 *   多线程争抢资源
 *
 *
 *   解决方案
 *       new Vector<>()
 *       Collections.synchronizedList(new ArrayList<>());
 *       new CopyOnWriteArrayList<>()  !!!
 *
 */
public class NotSafeDemo01 {

    public static void main(String[] args) {

       // List<String> arrayList1 = new Vector<>(); 线程安全  add 方法上加了 synchronized
        //   public synchronized boolean add(E e) {
        //        modCount++;
        //        ensureCapacityHelper(elementCount + 1);
        //        elementData[elementCount++] = e;
        //        return true;
        //    }
        /**\
         *   collection 集合接口
         *   collections  集合工具类
         */


        HashSet<Object> set = new HashSet<>();


        List<Object> arrayList = new CopyOnWriteArrayList<>();

        //  List<String> arrayList = new ArrayList<String>();  // 默认开始时大小为0的数组  当add时初始值为10的数组
        for (int i = 0; i < 3; i++) {
            new  Thread( () ->{
                arrayList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(arrayList +"s"+Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }
    }
}
