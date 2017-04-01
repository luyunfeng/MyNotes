Servlet细节
=========
## 1.在服务器启动时创建Servlet
  在web.xml里面

  > `<load-on-startup>0</load-on-startup>`

参数非负整数，按照数字的大小来决定启动顺序

    <servlet>
		<servlet-name>hello1</servlet-name>
		<servlet-class>servlet.HelloServlet</servlet-class>
		<load-on-startup>0</load-on-startup>
	</servlet>

##  <url-pattern> 

<url-pattern>是<servlet-mapping>的子元素，用来指定Servlet的访问路径，即URL。

可以绑定多个
  
还可以在<url-pattern>中使用通配符，

所谓通配符就是星号“*”，星号可以匹配任何URL前缀或后缀，

使用通配符可以命名一个Servlet绑定一组URL，例如：

* `<url-pattern>/servlet/*<url-patter>`
  > /servlet/a、/servlet/b，都匹配/servlet/*；
	
* `<url-pattern>*.do</url-pattern>`
  > /abc/def/ghi.do、/a.do，都匹配*.do；
	
* `<url-pattern>/*<url-pattern>`
 > 匹配所有URL；
 

