package com.li.jdk.innerclass;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.jdk.innerclass
 * @date 2021/2/2 10:59
 * @example:
 * @Description:
 */
public class Parcel {
    class Constens{
        private int i = 1;
        public int value(){return i;}
    }

    class Destination{
        private String label;
        public Destination(String whereTo){
            this.label= whereTo;
        }
        String readLabel(){return label;}
    }

    public Constens constens(){
        return new Constens();
    }

    public Destination to(String s){
        return new Destination(s);
    }

    public void ship(String dest){
        Constens constens = constens();
        Destination destination = to(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.ship("aaaaaaa");

        Constens c = p.constens();
        System.out.println(c.value());
    }
}
