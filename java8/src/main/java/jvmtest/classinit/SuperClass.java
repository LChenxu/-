package jvmtest.classinit;

/**
 * @author lichenxu
 * @version V1.0
 * @Package jvmtest
 * @date 2021/1/31 10:39
 * @example:
 * @Description:
 */
public class SuperClass {
    public static int m = 123;
    static {
        System.out.println("SuperClass init!");
    }

}
