package cn.lucode.java.$04_字符串.$02_字符串参数传递;

import org.junit.Test;

/**
 * Created by lucode on 2017/3/3.
 */
public class Demo01 {
    /*
    * 基本类型:形式参数的改变,不影响实际参数
    * 引用类型:形式参数的改变,影响实际参数(传递的是地址)
    * String 虽然是 引用类型,但是是在常量池里面操作的,
    * 所以在作为参数的时候和基本数据类型一样
    * */
    @Test
    public void test1(){
        String string="hello";
        change(string);
        // str 里面的值没有被改变
        System.out.println("String:   "+string);

        StringBuffer stringBuffer=new StringBuffer("hello");
        change(stringBuffer);
        // 里面的值被改变
        System.out.println("StringBuffer:   "+stringBuffer);

    }

    public void change(String string){
        string+="world";

    }
    public void change(StringBuffer stringBuffer){
        stringBuffer.append("world");

    }
}
