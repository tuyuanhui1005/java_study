public class TestMyAnnotation {

    public static void main(String[] args) {



        // 获取类上的注解
        Class<Test> clazz = Test.class;
        MyAnnotation annotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.getvalue());

    }
}
