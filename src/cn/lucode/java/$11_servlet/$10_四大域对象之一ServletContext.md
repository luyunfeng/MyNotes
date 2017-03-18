ServletContext
==============
**特点：**

  * 一个项目只有一个ServletContext对象
  * 生命周期和服务器一样

**ServletContext是JavaWeb四大域对象之一：**

* PageContext；
* ServletRequest；
* HttpSession；
* ServletContext；

**如何获取：**

   * GenericServlet:getServletContext();方法
   * HttpServlet:父类ServletConfig有getServletContext()可以this.getServletContext()来调用
   * ServletConfig（init方法中有这个参数）
   * ServletContextEvent
 
**一个域需要有如下功能：**

   * 可以存数据
   * 可以取数据
   * 内部有一个Map（和list类似，但不允许有相同，所以构成了键值对）
   
**ServletContext相关方法：**

* void setAttribute(String name, Object value)：如果使用相同的name，那么会覆盖上一次的值，这一特性与Map相同；
* Object getAttribute(String name)：
* void removeAttribute(String name)：用来移除ServletContext中的域属性，如果参数name指定的域属性不存在，那么本方法什么都不做；
* Enumeration getAttributeNames()：获取所有域属性的名称；

**获取公共初始化参数**
  
*	Servlet也可以获取初始化参数，但它是局部的参数；也就是说，一个Servlet只能获取自己的初始化参数，不能获取别人的，即初始化参数只为一个Servlet准备！
*	可以配置公共的初始化参数，为所有Servlet而用！这需要使用ServletContext才能使用！

假如在xml文件里面有如下内容（web-app目录下）
    
    <context-param>
	<param-name>paramName1</param-name>
	<param-value>paramValue1</param-value>  	
    </context-param>

//下面是是Servlet内容

     ServletContext context = this.getServletContext();
		String value1 = context.getInitParameter("paramName1");
		String value2 = context.getInitParameter("paramName2");
		System.out.println(value1 + ", " + value2);		
		Enumeration names = context.getInitParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
