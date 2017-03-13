[Toc]

# 1.自动拆装箱
```java
public class Test2
{
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}
```
> public void add(Byte b){ b=b++; }  
这里涉及java的自动装包/自动拆包(AutoBoxing/UnBoxing)  
Byte的首字母为大写，是类.  
看似是引用传递，但是在add函数内实现++操作，会自动拆包成byte值传递类型，所以add函数还是不能实现自增功能。也就是说add函数只是个摆设，没有任何作用。

> Byte类型值大小为-128~127之间.  
add(++a);这里++a会越界，a的值变为-128  add(b);   前面说了，add不起任何作用，b还是127


# 2.Java支持的数据类型有哪些？什么是自动拆装箱？

> Java语言支持的8种基本数据类型是：
byte short int long  float double boolean char

> ==自动装箱==是Java编译器在基本数据类型和对应的对象包装类型之间做的一个转化。比如：把int转化成Integer，double转化成Double，等等。反之就是自动拆箱。


# 3.静态块和静态变量

```java
public class test{
   static{
      //静态语句块中x为局部变量，不影响静态变量x的值
      int x=5;
   }
    /*x和y为静态变量，默认初始值为0，属于当前类，其值得改变会影响整个类运行。
    */
   static int x,y;
   public static void main(String args[]){
      x--;
      myMethod( );
      // 最后打印结果为3
     System.out.println(x+y+ ++x);
   }
   public static void myMethod( ){
      y=x++ + ++x;
   }
}
```


# 4.static关键字是什么意思？
“static”关键字表明一个成员变量
或者是成员方法可以在没有所属的类的实例变量的情况下被访问。

# 5.Java中是否可以覆盖(override)static的方法？
Java中static方法不能被覆盖  
因为方法覆盖是基于运行时动态绑定的  
而static方法是编译时静态绑定的。
static方法跟类的任何实例都不相关，所以概念上不适用。
简单来说方法覆盖(重写)是基于运行时动态绑定的,
但是 static 方法是编译的时候静态绑定.
# 6.Java中private方法能重写吗？

``` java
public class A {
     // 默认 final 不能被继承
    private void print() {
        System.out.println("A");
    }
    public static void main(String[] args) {
        A a = new B();
        a.print();
        B b = new B();
        b.print();
    }
}
class B extends A {
     //相当于另外添加的方法
    public void print() {    
        System.out.println("B");
    }
}
运行结果
A
B
```
分析:
>在Java中，所有的private方法默认是final的，
即不可继承的。所以当B继承A时，A的private方法print()不被B继承。
而B中的public方法print()相当于B添加的一个方法，不属于重写。


# 7.Java中的方法覆盖(Overriding)和方法重载(Overloading)是什么意思？
Java中的方法重载发生在同一个类里面两个或者是多个方法的方法名相同但是参数不同的情况。
与此相对，方法覆盖是说子类重新定义了父类的方法。
方法覆盖必须有相同的方法名，参数列表和返回类型。
覆盖者可能不会限制它所覆盖的方法的访问。

# 8. 接口和抽象类的区别是什么？
精辟的回答
从设计层面来说，
> 抽象是对类的抽象，是一种模板设计，
> 接口是行为的抽象，是一种行为的规范。

# 9.默认构造函数
It is an important feature of the Java language that it always provides a default constructor to a class.
总是为一个类提供了一个默认的构造函数是Java语言的一个重要特性 。
只有在没有定义 构造函数的时候 才会提供默认的构造函数

