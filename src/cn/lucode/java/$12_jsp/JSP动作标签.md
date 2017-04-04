JSP动作标签
================
### include 类似于请求包含

    <jsp:include page="b.jsp" >
      <jsp:param value="zhangsan" name="name"/>
      <jsp:param value="123456" name="password"/>
    </jsp:include>

上面用了传值的，在b.jsp上面可以这样写

    <h1>b.jsp</h1>
    <%
     String name =request.getParameter("name");
     String password=request.getParameter("password");
    %>
    <%=name%>
    <%=password%>
### forward 类似于请求转发

     <jsp:forward page="b.jsp" >