# (1)什么意思?
> 静态的意思,可以修饰成员变量和成员方法。
# (2) static 的特点：
> A:随着类的加载而加载  
> B:优先与对象存在  
> C:被类的所有对象共享(这其实也是我们判断该不该使用静态的依据)    
> D:可以通过类名调用(既可以通过对象名调用，也可以通过类名调用，建议通过类名调用。)

# (3)静态的内存
> 静态的内容在方法区的静态区
* (4)静态的注意事项；
> A:在静态方法中没有this对象  
> B:静态只能访问静态  
# (5)静态变量和成员变量的区别
* A:所属不同
>静态变量：属于类，类变量  
>成员变量：属于对象，对象变量，实例变量
* B:内存位置不同
> 静态变量：方法区的静态区  
> 成员变量：堆内存
* C:生命周期不同
> 静态变量：静态变量是随着类的加载而加载，随着类的消失而消失  
> 成员变量：成员变量是随着对象的创建而存在，随着对象的消失而消失
* D:调用不同
> 静态变量：可以通过对象名调用，也可以通过类名调用
> 成员变量：只能通过对象名调用
