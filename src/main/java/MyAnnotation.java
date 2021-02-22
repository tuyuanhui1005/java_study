public @interface MyAnnotation {

    String getvalue()  default "这是自定义注解！";
}
