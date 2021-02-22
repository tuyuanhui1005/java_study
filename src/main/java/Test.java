import java.sql.SQLTransactionRollbackException;

public class Test {


    @MyAnnotation(getvalue = "annotation on field")
    public static String name;


    @MyAnnotation
    public static void defaultMethod() {

    }

    @MyAnnotation(getvalue = "annotation on method")
    public static void hello() {

    }


}


