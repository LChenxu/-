package com.li.jdk.innerclass;

import org.junit.jupiter.api.Test;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.jdk.innerclass
 * @date 2021/2/2 11:12
 * @example:
 * @Description:
 */
public class Mytest {
    @Test
    public void test(){
        Parcel parcel = new Parcel();
        Parcel.Constens c = parcel.constens();
        System.out.println(c.value());
    }

}
