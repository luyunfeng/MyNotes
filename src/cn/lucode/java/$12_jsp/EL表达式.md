EL表达式
=======================

```
<body>
	  <%
		pageContext.setAttribute("xxx", "pagecontextXXX");
		request.setAttribute("xxx", "reuqestXXX");
		session.setAttribute("xxx", "sessionXXX");
		application.setAttribute("xxx", "applicationXXX");
	  %>
	 ${xxx}<br /><!--输出为最小的那个与对象 -->
	
	 ${pageScope.xxx}	<br />
	 ${requestScope.xxx}	<br />
	 ${sessionScope.xxx}	<br />
	 ${applicationScope.xxx}	<br /><!--输出指定的 -->
</body>
```


### javabean的使用

 Person类
 ```
     public class Person {
       private String name;
       private String age;
	  public String getName() {
		return name;
	 }
	  public void setName(String name) {
		this.name = name;
	 }
	//******
      public String getHehe(){//这个并没有属性
		return "卧槽";
     }
    }

 ```



 jsp中代码

    <body>
    <%
         Person p=new Person();
         p.setAge("80");
         p.setName("张三");
         request.setAttribute("p", p) ;
     %>
     ${p.name}<br/>
     ${p.hehe}  还是可以直接调用出来，但是要符合javabean规范
    </body>
