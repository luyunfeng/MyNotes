package cn.lucode.java.$02_基础;

import org.junit.Test;

/**
 * Created by lucode on 2017/4/28.
 */
public class 自动拆箱装箱 {
    @Test
    public void test() {
        Integer first = new Integer(3);
        Integer second = 3;
        int three = 3;
        System.out.println(first == second);//地址比较，Integer与Integer之间
        System.out.println(first == three);//自动拆装箱，Integer与int之间
        System.out.println(three == second);//自动拆装箱，Integer与int之间
        //false，true，true

    }

    @Test
    public void test2() {
        Integer a1 = 127, a2 = 127;
        Integer a3 = 128, a4 = 128;
        System.out.println(a1 == a2);
        System.out.println(a3 == a4);
        // true，false
        Integer a5 = new Integer(111);
        Integer a6 = new Integer(111);
        System.out.println(a5 == a6);
        // false
    }


}
