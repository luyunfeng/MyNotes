package cn.lucode.java.$03_类和对象.内部类;

/**
 * Created by lucode on 2017/3/14.
 */

 /*
     题目:
      要求请填空分别输出30，20，10。
     
     注意：
      1:内部类和外部类没有继承关系。
      2:通过外部类名限定this对象
       Outer.this
    */
public class Outer {
    public int num = 10;
    class Inner {
        public int num = 20;
        public void show() {
                int num = 30;
                System.out.println(num);//方法中的成员变量 直接输出没问题!
                System.out.println(this.num);// 类里面的成员方法, this 调用
                //System.out.println(new Outer().num);可以 new 一个对象
                System.out.println(Outer.this.num);
        }
    }
}
class InnerClassTest {
     public static void main(String[] args) {
         Outer.Inner oi = new Outer().new Inner();
         oi.show();
     }
}

