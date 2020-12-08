package cn.xysycx.jvm.c2_classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/8 下午2:00
 */
public class T012_ClassReloading2 {
    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {

            File f = new File("/home/xysycx/IdeaProjects/JVMTestCode/out/production/JVMTestCode/",
                    name.replace(".", "/").concat(".class"));

            if(!f.exists()){
                return super.loadClass(name);
            }

            try {

                InputStream is = new FileInputStream(f);

                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws Exception {
        MyLoader m = new MyLoader();
        Class clazz = m.loadClass("cn.xysycx.jvm.Hello");

        m = new MyLoader();
        Class clazzNew = m.loadClass("cn.xysycx.jvm.Hello");

        System.out.println(clazz == clazzNew);
    }
}
