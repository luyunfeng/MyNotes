package cn.lucode.java.$00_面试;

/**
 * Created by yunfeng.lu on 2017/8/14.
 */
public class test {
    //这是递归方法
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(10000));

    }

}
