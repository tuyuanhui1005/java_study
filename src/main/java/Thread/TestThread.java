package Thread;

import utils.webDownLoad;

public class TestThread extends Thread {


    private String url;//网络图片地址
    private String fileName;//保存的文件名


    public TestThread(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        webDownLoad wd = new webDownLoad();
        wd.downLoader(url, fileName);
        System.out.println("下载的文件名为：" + fileName);

    }

    public static void main(String[] args) {
        TestThread  thread1   = new  TestThread("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1466376595,3460773628&fm=26&gp=0.jpg","新恒结衣.jpg");
        TestThread  thread2   = new  TestThread("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3821523505,3593697188&fm=11&gp=0.jpg","杨幂.jpg");
        TestThread  thread3  = new  TestThread("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3265618386,1440309501&fm=26&gp=0.jpg","欧阳娜娜.jpg");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
