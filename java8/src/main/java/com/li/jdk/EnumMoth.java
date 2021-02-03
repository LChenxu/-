package com.li.jdk;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.jdk
 * @date 2021/1/13 14:49
 * @example:
 * @Description:
 */
public enum  EnumMoth {
    //
    January("一"){
        @Override
        String getInfo(){
            return "a";
        }
    },
    //
    February("二"){
        @Override
        String getInfo(){
            return "";
        }
    };
    private String name;
    private EnumMoth(String name){this.name = name;}
    public String getName(){
        return name;
    }
    abstract String getInfo();
    public static void main(String[] args) {
        for (EnumMoth e:EnumMoth.values()){
            System.out.println(e+" : "+e.getName());
        }
    }
}
