package cn.xysycx.jvm.c2_classloader;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午1:28
 */
public class T005_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = T005_LoadClassByHand.class.getClassLoader().loadClass("cn.xysycx.jvm.c2_classloader.T002_ClassLoaderLevel");
        System.out.println(clazz.getName());

        //利用类加载器加载资源，参考坦克图片的加载
        //T005_LoadClassByHand.class.getClassLoader().getResourceAsStream("");
    }
}
