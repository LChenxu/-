package jvmtest.clinit;

/**
 * @author lichenxu
 * @version V1.0
 * @Package jvmtest.clinit
 * @date 2021/1/31 15:52
 * @example:
 * @Description:
 */
public class ClinitTest {

    static {
        m = 0;
//        System.out.println(m); 报错
    }

    private static int m = 1;

}
