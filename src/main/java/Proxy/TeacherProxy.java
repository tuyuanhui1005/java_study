package Proxy;

import java.util.Arrays;

public class TeacherProxy   implements ITeacherDao {

    ITeacherDao target;

    public TeacherProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teacher() {
        System.out.println("开始代理");
        target.teacher();
        System.out.println(Arrays.toString(target.getClass().getInterfaces()));
        System.out.println("结束代理");

    }


}
