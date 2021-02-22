package Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private  Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public  Object getProxyInstance(){

        /**
         *    public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         *    ClassLoader loader, 指定当前目标对象使用的类加载器，获取加载器的方法是固定的
         *    Class<?>[] interfaces, 目标对象实现的接口
         *    InvocationHandler h ,事件处理，执行目标对象的方法时，会去触发事件处理器的方法
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理开始了。。。。。。");
                        Object invoke = method.invoke(target, args);
                        return invoke;
                    }
                });
    }
}
