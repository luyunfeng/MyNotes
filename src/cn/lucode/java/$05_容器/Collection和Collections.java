package cn.lucode.java.$05_容器;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lucode on 2017/3/14.
 */

/**
 * Collection:
 * 集合类的一个顶级接口
 * Collections:
 * 集合类的一个工具类/帮助类，
 * 其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
 */
public class Collection和Collections {
    // 演示Collections工具类的排序方法
    @Test
    public void Test() {
        ArrayList list = new ArrayList();
        double array[] = {112, 111, 23, 456, 231};
        for (int i = 0; i < array.length; i++) {
            list.add(new Double(array[i]));
        }
        // 静态类 直接来
        Collections.sort(list);
        for (int i = 0; i < array.length; i++) {
            System.out.println(list.get(i));
        }

    }
}
