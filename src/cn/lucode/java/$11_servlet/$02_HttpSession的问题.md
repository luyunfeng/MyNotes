* HttpSession session = request.getSession(false) 

* HttpSession session = request.getSession(true)

###  区别

1、request.getSession() 等价于 
   request.getSession(true) 
   这两个方法的作用是相同的，
   查找请求中是否有关联的session id，
   如果有则返回这个号码所对应的session对象，
   如果没有则生成一个新的session对象。
   所以说，通过此方法是一定可以获得一个session对象。 

2、request.getSession(false) 
   查找请求中是否有关联的session id，
   如果有则返回这个号码所对应的session对象，
   如果没有则返回一个null。
   
## 所以
在实际程序中

```java

HttpSession session = request.getSession();  
// a new session created if no session exists， 
// 哈哈！完蛋啦！如果session不存在的话你又创建了一个！  
// 然后下面的  出问题!!
String user_name = session.getAttribute("user_name");

```

改进版

```java
HttpSession session = request.getSession(false);  
if (session != null) {  
    String user_name = session.getAttribute("user_name");  
}  

```
