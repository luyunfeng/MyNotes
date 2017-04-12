# 1.序列化是干什么的？
简单说就是为了保存在内存中的各种对象的状态，  
也就是实例变量，不是方法，  
并且可以把保存的对象状态再读出来。  
虽然你可以用你自己的各种各样的方法来保存object states，  
但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化。
# 2.什么情况下需要序列化

* 当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；  

* 当你想用套接字在网络上传送对象的时候；   

* 当你想通过RMI传输对象的时候；  

# 3.一个例子
序列化需要实现Serializable或者Externalizable 接口
下面的是实现Serializable接口，最后会提到Externalizable 

```java
import java.io.Serializable;  
  
public class Student implements Serializable  
{  
 private String name;  
 private char sex;  
 private int year;  
 private double gpa;  
  
 public Student(){  
 }  
 public Student(String name,char sex,int year,double gpa)  
 {  
  this.name = name;  
  this.sex = sex;  
  this.year = year;  
  this.gpa = gpa;  
 }  
 //....getxxx setxxx  方法
}  

```
```java
import java.io.*;  

public class UseStudent  
{  
 public static void main(String[] args)  
 {  
  Student st = new Student("德玛西亚",'M',20,3.6);  
  File file = new File("student.txt");  
  try  
  {  
   file.createNewFile();  
  }  
  catch(IOException e)  
  {  
   e.printStackTrace();  
  }  
  try  
  {  
   //Student对象序列化过程  
   FileOutputStream fos = new FileOutputStream(file);  
   ObjectOutputStream oos = new ObjectOutputStream(fos);  
   oos.writeObject(st);  
   oos.flush();  
   oos.close();  
   fos.close();  
  
   //Student对象反序列化过程  
   FileInputStream fis = new FileInputStream(file);  
   ObjectInputStream ois = new ObjectInputStream(fis);  
   Student st1 = (Student) ois.readObject();  
   System.out.println("name = " + st1.getName());  
   System.out.println("sex = " + st1.getSex());  
   System.out.println("year = " + st1.getYear());  
   System.out.println("gpa = " + st1.getGpa());  
   ois.close();  
   fis.close();  
  }  
  catch(ClassNotFoundException e)  
  {  
   e.printStackTrace();  
  }  
  catch (IOException e)  
  {  
   e.printStackTrace();  
  }               
 }  
}  
```
# 4.使用transient

在一些特殊场景下，比如银行账户对象，出于保密考虑，
不希望对存款金额进行序列化。或者类的一些引用类型的成员是不可序列化的。
此时可以使用transient关键字修饰不想被或者不能被序列化的成员变量。
需要注意的是transient只能修饰属性（filed），不能修饰类或方法。 
一个静态变量不管是否被transient修饰，均不能被序列化。 

# 5.自定义序列化

transient提供了一种简洁的方式将被transient修饰的成员属性完全隔离在序列化机制之外。
这样子固然不错，但是Java还提供了一种自定义序列化机制让开发者更自由地控制如何序列化各个成员属性，
或者不序列化某些属性（与transient效果相同）。

## 5.1 writeObject和readObject

```
private void writeObject(ObjectOutputStream out)
private void readObject(ObjectInputStream in)
```
这两个方法和ObjectOutputStream及ObjectInputStream里对应的方法名称相同。
实际上，尽管这两个方法是private型的，但是仍然是在被序列化（或反序列化）阶段被外部类ObjectOutputStream（或ObjectInputStream）调用。
仅以序列化为例：
ObjectOutputStream在执行自己的writeObject方法前会先通过反射在要被序列化的对象的类中
查找有无自定义的writeObject方法，
如有的话，则会优先调用自定义的writeObject方法。
因为查找反射方法时使用的是getPrivateMethod，
所以自定以的writeObject方法的作用域要被设置为private。
通过自定义writeObject和readObject方法可以完全控制对象的序列化与反序列化。
```java

/**
 * 序列化测试类
 */
public class SerialTest {

    public static void main(String[] args) {
        Person robin = new Person("robin", 29);
        String savePath = "object.txt";

        SerialTest test = new SerialTest();

        try {
            test.serialize(savePath, robin);
            Person person = (Person) test.deSerialize(savePath);
            
            System.out.println("Name:" + person.getName()
                             +" Age:" + person.getAge());
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }


/**
 * Person类，可序列化

class Person implements Serializable {

    private static final long serialVersionUID = -6412852654889352693L;

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*  略去get和set，请自行实现  */
    
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeObject(name);
        out.writeInt(age + 1);
        System.out.println("my write");
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        this.name = "zhangsan";
        this.age = 30;
        System.out.println("my read");
    }
}
```
## 5.2 writeReplace和readResolve

writeReplace和readResolve是一种更彻底的序列化的机制，
它甚至可以将序列化的目标对象替换为其它的对象。
但是与writeObject和readObject不同的是，
这二者不是必须要一起使用的，而且尽量应分开使用。
若一起使用的话，只有writeReplace会生效。
# 6.使用Externalizable

一开始有提到过实现Externalizable接口也可以实现类的序列化。
使用这种方法，可以由开发者完全决定如何序列化和反序列化目标对象。
Externalizable接口提供了writeExternal和readExternal两个方法。
实际上这种方法和前面的自定义序列化方法很相似，
只是Externalizable强制自定义序列化。
在使用了Externalizable的类中仍可以使用writeReplace和readResolve方法。
使用Externalizable进行序列化较之使用Serializable性能略好，但是复杂度较高。