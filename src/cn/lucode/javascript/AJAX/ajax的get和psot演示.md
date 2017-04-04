## ajax的解释
asynchronous javascript and xml：
> 异步的js和xml

## get请求
客户端页面

```html
<html>
<head>
<base href="<%=basePath%>">

<script type="text/javascript">
	//创建对象XMLHttpRequest
	function createXMLHttpRequest() {
		var xmlHttp;
		try {
		xmlHttp = new XMLHttpRequest();
			return xmlHttp;
		} catch (e) {
			//ie 浏览器 的内容  暂时不管他
			throw e;
		}
	}
	function dianji() {
		//1.得到异步对象
		xmlHttpRequset = createXMLHttpRequest();
		//2.与服务器创建联系
		//这里的传递url采用jsp标签方式，
		//最后那个true 表示：如果为true表示发送异步请求，否则同步请求！
		xmlHttpRequset.open("GET", "/ajax/AServlet",true);
        //3.发送请求
        //参数：就是请求体内容！如果是GET请求，必须给出null。
        xmlHttpRequset.send(null);
        //4.监听 页面加载情况
        xmlHttpRequset.onreadystatechange=function(){
           if(xmlHttpRequset.readyState==4
           &&xmlHttpRequset.status==200){
           //得到服务器文本内容 
           //xmlHttp.responseXML是得到xml内容
           var text=xmlHttpRequset.responseText;
           //使用doc对象得到标签
           var div=document.getElementById("div");
           //把从服务器搞到的东西传入页面
           div.innerHTML=text;
           }
        };
	}
</script>
</head>
<body>
	<button onclick="dianji()">点击获取</button>
	<!-- 服务器里面搞出来的东西在这里显示出来 -->
	<div id="div"></div>
</body>
</html>

```
服务端器代码
```java
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		PrintWriter out = response.getWriter();
		out.print("Hello Ajax!!! ");
		
		out.close();
}
```




## post请求
客户端页面

```html
<html>
<head>
<title>注册</title>
<script type="text/javascript">
	//创建对象XMLHttpRequest
	function createXMLHttpRequest() {
		var xmlHttp;
		try {
			xmlHttp = new XMLHttpRequest();
			return xmlHttp;
		} catch (e) {
			//ie 之前版本可能出现 异常  详细解决见文档  暂时不管他
			throw e;
		}
	}
	function yanzheng() {
		//得到post请求
		var user = document.getElementById("user");

		//1.得到异步对象
		xmlHttpRequset = createXMLHttpRequest();
		//2.与服务器创建联系

		//最后那个true 表示：如果为true表示发送异步请求，否则同步请求！
		xmlHttpRequset.open("POST", "/ajax/AServlet", true);
		//psot 设置请求头
		xmlHttpRequset.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		//3.发送请求
		//参数：就是请求体内容！如果是GET请求，必须给出null。
		xmlHttpRequset.send("username=" + user.value);
		//4.监听 页面加载情况
		xmlHttpRequset.onreadystatechange = function() {
			if (xmlHttpRequset.readyState == 4 && xmlHttpRequset.status == 200) {
				//得到服务器文本内容 
				//xmlHttp.responseXML是得到xml内容
				var text = xmlHttpRequset.responseText;
				//使用doc对象得到标签
				var div = document.getElementById("error");
				if (text == "1") {
					//把从服务器搞到的东西传入页面
					div.innerHTML = "error";
				} else {
//分情况把处理
					div.innerHTML = "yes";
				}
			}
		};
	}
</script>

</head>
<body>
	<form action="" method="post">
		用户名：<input id="user" type="text" name="username" onblur="yanzheng()" />
<!—如果出现用户名重复就在这里显示出来-->
		<span id="error"></span><br />
<input type="submit" value="注册" />
</body>
</html>
```

服务器端代码
```java
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		if(username.equalsIgnoreCase("zhangsan")){
			out.print("1");
			System.out.println("error");
		}else{
			out.print("2");
			System.out.println("yes");
		}
		out.close();
	}

```
