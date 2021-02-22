package Proxy;

public class user {

    public static void main(String[] args) {
        TeacherDao td = new TeacherDao();

        TeacherDao1 td1 = new TeacherDao1();
        TeacherProxy tp = new TeacherProxy(td);
        tp.teacher();




    }
}
