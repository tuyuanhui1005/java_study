package Proxy.dynamicProxy;

import Proxy.dynamicProxy.ITeacherDao;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("语文老师授课中。。。");
    }


}
