package JUC;

import java.util.ArrayList;

public class NotSafeDemo01 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();  // 默认开始时大小为0的数组  当add时初始值为10的数组
        arrayList.add(1);
    }
}
