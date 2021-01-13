package Volatile;

public class VisibilityDemo  {




    public static void main(String[] args) {

        myThread myThread = new myThread();
        myThread.start();
        while (true){
            if(myThread.flag){
                System.out.println("主线程进入循环执行---------");
            }
        }

    }
}


class   myThread extends  Thread{

    //成员变量
    boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //触发修改成员变量
        flag = true;
        System.out.println(flag);
    }



}
