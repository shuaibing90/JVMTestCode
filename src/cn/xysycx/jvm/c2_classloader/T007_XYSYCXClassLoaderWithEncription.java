package cn.xysycx.jvm.c2_classloader;

import cn.xysycx.jvm.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午1:42
 */
public class T007_XYSYCXClassLoaderWithEncription extends ClassLoader {
    public static int seed = 0B10110110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File f = new File("/home/xysycx/IdeaProjects/JVMTestCode/out/production/JVMTestCode/",
                name.replace(".", "/").concat(".xysycxclass"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b=fis.read()) !=0) {
                baos.write(b ^ seed);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();//可以写的更加严谨

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }

    public static void main(String[] args) throws Exception {
        encFile("cn.xysycx.jvm.Hello");

        ClassLoader l = new T007_XYSYCXClassLoaderWithEncription();
        Class clazz = l.loadClass("cn.xysycx.jvm.Hello");
        Hello h = (Hello)clazz.newInstance();
        h.m();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());

    }

    private static void encFile(String name) throws Exception{
        File f = new File("/home/xysycx/IdeaProjects/JVMTestCode/out/production/JVMTestCode/",
                name.replace(".", "/").concat(".class"));
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(new File("/home/xysycx/IdeaProjects/JVMTestCode/out/production/JVMTestCode/", name.replaceAll(".", "/").concat(".xysycxclass")));
        int b = 0;
        while((b = fis.read()) != -1) {
            fos.write(b ^ seed);
        }

        fis.close();
        fos.close();


    }
}
