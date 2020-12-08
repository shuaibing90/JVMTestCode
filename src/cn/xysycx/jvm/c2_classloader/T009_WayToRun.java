package cn.xysycx.jvm.c2_classloader;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午1:54
 */
public class T009_WayToRun {
    public static void main(String[] args) {
        for(int i=0; i<10_0000; i++)
            m();

        long start = System.currentTimeMillis();
        for(int i=0; i<10_0000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void m() {
        for(long i=0; i<10_0000L; i++) {
            long j = i%3;
        }
    }
}
