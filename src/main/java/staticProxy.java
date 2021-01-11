
//静态代理模式
public class staticProxy {


    public static void main(String[] args) {
       you y =  new you();
       new Thread( ()-> System.out.println("我爱你")).start();

       new weddingCompany(new you()).happyMarry();


//        weddingCompany weddingCompany = new weddingCompany(new you());
//        weddingCompany.happyMarry();
    }
}

interface Marry {

    void happyMarry();
}

//真实角色
class weddingCompany implements Marry {
    private Marry target;

    public weddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();//真实对象
        after();

    }

    private void after() {
        System.out.println("结婚之后。。。。。。。。");
    }

    private void before() {
        System.out.println("结婚之前。。。。。。。。");
    }
}

//代理角色
class you implements Marry {


    @Override
    public void happyMarry() {
        System.out.println("我要结婚了，很开心");
    }
}
