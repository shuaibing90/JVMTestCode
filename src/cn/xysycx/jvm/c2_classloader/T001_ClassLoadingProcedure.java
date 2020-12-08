package cn.xysycx.jvm.c2_classloader;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午2:19
 */
public class T001_ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T {
    public static int count = 2; //0
    public static T t = new T(); // null

    //private int m = 8;

    private T() {
        count ++;
        //System.out.println("--" + count);
    }
}
