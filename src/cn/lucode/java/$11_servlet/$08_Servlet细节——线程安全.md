Servlet细节——线程安全
====================
由于Servlet是单例，也就是只有一个对象，所以存在**线程不安全**的问题
同时处理多个请求

线程不安全也有好处：处理速度快

----------------

### 所以才写Servlet的时候要注意:

  * 不要在Servlet中创建成员！创建局部变量即可！
   
  *	可以创建无状态成员！
  >  比如一个成员方法里面没有数据变化
  
  *	可以创建有状态的成员，但状态必须为只读的！
  > 只有getxxx()方法，没有setxxx()


