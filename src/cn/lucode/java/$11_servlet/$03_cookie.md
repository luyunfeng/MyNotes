### 什么是 cookie
Cookie是由服务器端生成，发送给User-Agent（一般是浏览器），
浏览器会将Cookie的key/value保存到某个目录下的文本文件内，
下次请求同一网站时就发送该Cookie给服务器（前提是浏览器设置为启用cookie）.
Cookie名称和值可以由服务器端开发自己定义，
对于JSP而言也可以直接写入JSESSIONID用于标记一个会话(session)，
这样服务器可以知道该用户是否合法用户以及是否需要重新登录等，
服务器可以设置或读取Cookies中包含信息，借此维护用户跟服务器会话中的状态。
(网上抄来的)

### 生命周期

默认关闭浏览器就结束  
当然有方法可以设置
* cookie.setMaxAge(3600);

### 一个Demo

Cookie设置保存时间，记录上次访问时间
```java
public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	
	Cookie cookie = new Cookie("lasttime", new Date().toString());
  //表示时间为一个小时保存
	cookie.setMaxAge(60 * 60);
	response.addCookie(cookie);
	
	Cookie[] cs = request.getCookies();
	String s = "您是首次访问本站！";
	if(cs != null) {
		for(Cookie c : cs) {
			if(c.getName().equals("lasttime")) {
				s = "您上次的访问时间是：" + c.getValue();
			}
		}
	}
	response.getWriter().print(s);
}


```