package cn.lucode.java.$02_基础;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by lucode on 2017/3/27.
 */
public class 异常Demo {
    @Test
    public void fun() throws Exception {

        try{
            throw new Exception("1");
        }catch (IOException e){
            throw new Exception("2");
        }catch (Exception e) {
            throw new Exception("3");
        }finally {
            throw new Exception("4");
        }


        // 最后的异常会抛出
    }

}
