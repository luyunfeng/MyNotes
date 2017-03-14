package cn.lucode.java.$05_容器;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lucode on 2017/3/14.
 */
public class 集合去重 {
    public static void main(String[] args) {

        ArrayList arr = new ArrayList();
        arr.add("hello");
        arr.add("world");
        arr.add("java");
        arr.add("world");
        arr.add("world");
        arr.add("world");
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        //遍历每一个元素,和后面的元素相比较,重复的去掉后面这个元素
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                    if (arr.get(i).equals(arr.get(j))) {
                        arr.remove(j);
                        j--;
                    }
            }
        }
        System.out.println("----------------------");
        Iterator it1 = arr.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next().toString());
        }
    }
}
