package cn.lucode.java.$02_基础;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucode on 2017/7/8.
 */
public class Test {
    @org.junit.Test
    public void test(){
        Map<String,Integer> map=new HashMap<>();
        map.put("qwe",0);
        int a=map.get("qwe").intValue();
        map.put("qwe",++a);
        System.out.println(map.toString());

        map.clear();

        System.out.println(map.toString());

    }



}
