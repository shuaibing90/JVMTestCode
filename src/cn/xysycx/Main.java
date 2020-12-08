package cn.xysycx;

import cn.xysycx.jvm.Hello;
import cn.xysycx.jvm.c1_bytecode.*;
import cn.xysycx.jvm.c2_classloader.T010_Parent;

public class Main {

    public static void main(String[] args) {
	// write your code here
        new T0100_ByteCode01();
        new T0101_ByteCode_With_Interfaces();
        new T0102_ByteCode02();
        new T0103_ByteCode03();
        new T0104_ByteCode04(1,"a");
        new T0105_ByteCode05(1,"a");
        new T0106_ByteCode06();
        new Hello();


    }
}
