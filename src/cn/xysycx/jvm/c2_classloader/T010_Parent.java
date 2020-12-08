package cn.xysycx.jvm.c2_classloader;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午1:56
 */
public class T010_Parent {
    private static T006_XYSYCXClassLoader parent = new T006_XYSYCXClassLoader();

    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            super(parent);
        }
    }
}
