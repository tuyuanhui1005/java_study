
// 任何接口  如果只包含唯一一个抽象方法，name它就是一个函数式接口
public class lambda {



    public static void main(String[] args) {
//        ilike ilike = new ilike();
//        ilike.lambda();

        new like() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        }.lambda();


        like like  =  () -> {
            System.out.println("lambda 表达式");
        };
        like.lambda();
    }
}


interface  like{
    void lambda();
}

class ilike implements  like{

    @Override
    public void lambda() {
        System.out.println("i like lambda..........");

    }
}
