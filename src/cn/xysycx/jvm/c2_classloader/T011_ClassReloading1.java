package cn.xysycx.jvm.c2_classloader;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午1:58
 */
public class T011_ClassReloading1 {
    public static void main(String[] args) throws Exception {
        T006_XYSYCXClassLoader msbClassLoader = new T006_XYSYCXClassLoader();
        Class clazz = msbClassLoader.loadClass("cn.xysycx.jvm.Hello");

        msbClassLoader = null;
        System.out.println(clazz.hashCode());

        msbClassLoader = null;

        msbClassLoader = new T006_XYSYCXClassLoader();
        Class clazz1 = msbClassLoader.loadClass("cn.xysycx.jvm.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
