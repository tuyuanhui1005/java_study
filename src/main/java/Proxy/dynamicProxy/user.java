package Proxy.dynamicProxy;

public class user {

    public static void main(String[] args) {
        ITeacherDao dao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(dao);
        ITeacherDao proxyInstance = (ITeacherDao)proxyFactory.getProxyInstance();
        System.out.println(proxyInstance);
    }
}
