package cn.lucode.java.$02_基础;

import org.junit.Test;

/**
 * Created by lucode on 2017/3/27.
 */
public class switchDemo {

    @Test
    public void fun(){
        int type=4;
        switch (type) {
            default:
                System.out.println(4);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
        }

        // 输出结果  4 1 2 3


    }


}
