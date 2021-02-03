package com.li.jdk;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.jdk
 * @date 2021/1/21 15:15
 * @example:
 * @Description:
 */
public class TestDemo {

    private int a = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private static void f(TestDemo td){
        td = new TestDemo();
    }

    private static void f2(TestDemo td) {
        td.setA(200);
    }

    public static void main(String[] args) {
        TestDemo td = new TestDemo();
        td.setA(100);
        System.out.println(td.getA());
        f(td);
        System.out.println(td.getA());
        f2(td);
        System.out.println(td.getA());
    }
}
