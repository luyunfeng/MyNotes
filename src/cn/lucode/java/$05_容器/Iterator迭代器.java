package cn.lucode.java.$05_容器;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by lucode on 2017/3/14.
 */
public class Iterator迭代器 {
    // 遍历元素的两种方式
    @Test
    public void Test() {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");
        // Iterator iterator():迭代器，集合的专用遍历方式
        // 实际返回的肯定是子类对象，这里是多态
        Iterator it = c.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            String s = (String) it.next();
            System.out.println(s);
        }
        System.out.println("---------");
        //for循环改进 减少空间 it
        for (Iterator it2 = c.iterator(); it2.hasNext(); ) {
            System.out.println(it2.next());
        }
    }

    //删除元素
    @Test
    public void Test2() {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");

        for (int i = 0; i < c.size(); i++) {
            c.remove("world");
            System.out.println("c.size():"+c.size());
        }

        // 遍历打印出来
        Iterator it = c.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            String s = (String) it.next();
            System.out.println(s);
        }


    }


}
