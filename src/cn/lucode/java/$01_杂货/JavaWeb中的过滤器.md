# 1. 什么是过滤器
过滤器JavaWeb三大组件之一，它与Servlet很相似！
过滤器是用来拦截请求的，
当用户请求某个Servlet时，会先执行部署在这个请求上的Filter，  
如果Filter「放行」，那么会继承执行用户请求的Servlet；  
如果Filter「不放行」，那么就不会执行用户请求的Servlet。  
# 2. 先上一个 Demo
只拦截 index 页面   
第一步：
```java
public class HelloFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Hello Filter");
	}
	public void destroy() {}
}
```
第二步：在web.xml文件中部署Filter：
```
  <filter>
  	<filter-name>helloFilter</filter-name>
  	<filter-class>cn.filter.HelloFilter</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>helloFilter</filter-name>
  	<url-pattern>/index.jsp</url-pattern>
  </filter-mapping>
```
执行效果：   
现在可以尝试去访问index.jsp页面了，看看是什么效果！（控制台输出 Hello Filter）
当用户访问index.jsp页面时，会执行HelloFilter的doFilter()方法！
在我们的示例中，index.jsp页面是不会被执行的，
如果想执行index.jsp页面，那么我们需要放行！

# 3. 生命周期
## 3.1生命周期方法

### 3.1.1 init 
```
init(FilterConfig) 
```
 
在服务器启动时会创建Filter实例，并且每个类型的Filter只创建一个实例，从此不再创建！
在创建完Filter实例后，会马上调用init()方法完成初始化工作;   
这个方法只会被执行一次；  

### 3.1.2 doFilter
```
doFilter(ServletRequest req,ServletResponse res,FilterChain chain)    
```
这个方法会在用户每次访问
目标资源（<url->pattern>index.jsp</url-pattern>）时执行，  
如果需要“放行”，那么需要调用FilterChain的doFilter(ServletRequest,ServletResponse)方法，
如果不调用FilterChain的doFilter()方法，那么目标资源将无法执行；

### 3.1.3 destroy
```
destroy()
```
服务器会在创建Filter对象之后，把Filter放到缓存中一直使用，通常不会销毁它。  
一般会在服务器关闭时销毁Filter对象;  
在销毁Filter对象之前，服务器会调用Filter对象的destory()方法。

## 3.2 相关的类和方法
### 3.2.1 FilterConfig

Filter接口中的init()方法的参数类型为FilterConfig类型。
它的功能与ServletConfig相似，与web.xml文件中的配置信息对应。
下面是FilterConfig的功能介绍：
```
// 获取ServletContext的方法；
ServletContext getServletContext()
// 获取Filter的配置名称；与<filter-name>元素对应；
String getFilterName()
// 获取Filter的初始化配置，与<init-param>元素对应；
String getInitParameter(String name)
// 获取所有初始化参数的名称。
Enumeration getInitParameterNames()
```

### 3.2.2 FilterChain
doFilter()方法的参数中有一个类型为FilterChain的参数，
它只有一个方法：doFilter(ServletRequest,ServletResponse)。
前面我们说doFilter()方法的放行，让请求流访问目标资源！
但这么说不严密，其实调用该方法的意思是:
『我（当前Filter）』放行了，但不代表其他人（其他过滤器）也放行。   
也就是说，一个目标资源上，可能部署了多个过滤器，
就好比在你去北京的路上有多个打劫的匪人（过滤器），而其中第一伙匪人放行了，
但不代表第二伙匪人也放行了，
所以调用FilterChain类的doFilter()方法表示的是执行下一个过滤器的doFilter()方法，
或者是执行目标资源！
如果当前过滤器是最后一个过滤器，那么调用chain.doFilter()方法表示执行目标资源，
而不是最后一个过滤器，那么chain.doFilter()表示执行下一个过滤器的doFilter()方法。


# 4. 多个过滤器执行顺序
一个目标资源可以指定多个过滤器，过滤器的执行顺序是在web.xml文件中的部署顺序。

# 四种拦截方式
一个测试，写一个过滤器，指定过滤的资源为b.jsp，
然后我们在浏览器中直接访问b.jsp，你会发现过滤器执行了！
但是当我们在a.jsp中  
request.getRequestDispathcer(“/b.jsp”).forward(request,response)时，
就不会再执行过滤器了！
也就是说，默认情况下，只能直接访问目标资源才会执行过滤器，
而forward执行目标资源，不会执行过滤器！
```
http://localhost:8080/filtertest/b.jsp -->直接访问b.jsp时，会执行过滤器内容；
http://localhost:8080/filtertest/a.jsp --> 访问a.jsp，但a.jsp会forward到b.jsp，这时就不会执行过滤器！

```

其实过滤器有四种拦截方式！

* REQUEST  

> 直接访问目标资源时执行过滤器。  
> 包括：在地址栏中直接访问、表单提交、超链接、重定向，只要在地址栏中可以看到目标资源的路径，就是REQUEST；
```
<!--当没有给出拦截方式时，那么默认为REQUEST-->
<filter-mapping>
		<filter-name>myfilter</filter-name>
		<url-pattern>/b.jsp</url-pattern>
</filter-mapping>
```
* FORWARD  

> 转发访问执行过滤器。  
> 包括RequestDispatcher#forward()方法、```<jsp:forward>```标签都是转发访问；

```
<!--b.jsp为目标资源，当直接请求b.jsp时，会执行过滤器;
    当转发到b.jsp页面时，会执行过滤器-->
<filter-mapping>
		<filter-name>myfilter</filter-name>
		<url-pattern>/b.jsp</url-pattern>
		<dispatcher>REQUEST</dispatcher>
		<dispatcher>FORWARD</dispatcher>
	</filter-mapping>
```
* INCLUDE  

> 包含访问执行过滤器。  
> 包括RequestDispatcher#include()方法、```<jsp:include>```标签都是包含访问；

* ERROR  

> 当目标资源在web.xml中配置为<error-page>中时，并且真的出现了异常，转发到目标资源时，会执行过滤器。

```
	<filter-mapping>
		<filter-name>myfilter</filter-name>
		<url-pattern>/b.jsp</url-pattern>
		<dispatcher>ERROR</dispatcher>
	</filter-mapping>
	<error-page>
		<error-code>500</error-code>
		<location>/b.jsp</location>
	</error-page>
```
```
  <body>
  <h1>a.jsp</h1>
   <%
   if(true)
   	throw new RuntimeException("嘻嘻~");
   %>
  </body>

```




