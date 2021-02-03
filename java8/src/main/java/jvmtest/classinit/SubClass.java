package jvmtest.classinit;

/**
 * @author lichenxu
 * @version V1.0
 * @Package jvmtest.classinit
 * @date 2021/1/31 10:41
 * @example:
 * @Description:
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}
