response（响应）
=======================
##  Http协议

### 状态码：

   * 200表示成功
   * 302表示重定向
   * 404表示客户端错（访问的资源不存在）
   * 500表示服务器端错

发送状态码(doGet)

  > sendError(int sc)  发送错误状态码，例如404、500
 
  > sendError(int sc, String msg)  也是发送错误状态码，还可以带一个错误信息！
  
  > setStatus(int sc)  发送成功的状态码，可以用来发送302

```java
    public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.sendError(404,"内容存在就是不给你看");
	}
    }
```
###  响应头：
  头就是一个键值对！可能会存在一个头（一个名称，一个值）

  也可能会存在多个头（一个名称，多个值！）

* setHeader(String name, String value)

 > 适用于单值的响应头

 > 例如：response.setHeader("aaa", "AAA");

------------------------------
* addHeader(String name, String value)
> 适用于多值的响应头
> response.addHeader("aaa", "A");
> 
> response.addHeader("aaa", "AA");
> 
> response.addHeader("aaa", "AAA");

------------------
* setIntHeader(String name, int value)
* response.setIntHeader("Content-Length", 888);
* addIntHeader(String name, int value)
* setDateHeader(String name, long value)
* response.setDateHeader("expires", 1000 * 60 * 60 * 24)
* addDateHeader(String name, long value)

##### 案例——重定向

>建立两个Servlet，在第一个Servlet写

    public class BServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BServlet");
		/*
		 * 1.设置Location
		 * 2.发送状态码302
		 * */
		response.setHeader("Location", "/ServletDemo3/CServlet");
       //转向的地址，/项目名/转向的Servlet名字
		response.setStatus(302);	
	}
    }
##### 案例——定时重定向（定时刷新）
> 五秒钟后跳转到相关页面.....

在doGet()方法里面可以写页面但是跳转语句不能写在最后面（其实不能写在out.close()方法后面，原因还需探究）

close之后关闭所有资源，所有响应头没有包含进去


    public class DServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //跳转语句，添加头，一定要写在最前面 3是跳转时间
	    response.setHeader("Refresh", "3;URL=/ServletDemo3/EServlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		 out.println("5555");
		 out.flush();
         out.close();
	}
    }
##### 案例——禁用浏览器缓存

设置这三个响应头

> Cache-Control、pragma、expires
> 
> <meta>标签可以代替响应头：<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
> 具体看jsp首页

    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

##### 案例——字节数组打印图片

    public class FServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="C:\\Users\\Administrator\\Pictures\\001.jpg";
		FileInputStream in=new FileInputStream(path);
         //用工具类直接得到字节数组
		byte[]b=IOUtils.toByteArray(in);
		response.getOutputStream().write(b);
	}
    }


##### 案例———快捷重定向

>response.sendRedirect("/ServletDemo3/CServlet");

参数直接传入Location的地址
