jsp中和javabean相关的标签
==================
###在JSP中与JavaBean相关的标签有：

	<jsp:useBean>：创建JavaBean对象；有的话就是查找
	<jsp:setProperty>：设置JavaBean属性；
	<jsp:getProperty>：获取JavaBean属性；

<jsp:useBean>标签默认是把JavaBean对象保存到page域，还可以通过scope标签属性来指定保存的范围：
    
    
    <jsp:useBean id="user1" class="cn.yunfenglu.domain.User" scope="page"/>
    <jsp:useBean id="user2" class="cn.yunfenglu.domain.User" scope="request"/>
    <jsp:useBean id="user3" class="cn.yunfenglu.domain.User" scope="session"/>
    <jsp:useBean id="user4" class="cn.yunfenglu.domain.User" scope="applicatioin"/>

<jsp:setProperty>标签的作用是给JavaBean设置属性值，而<jsp:getProperty>是用来获取属性值。在使用它们之前需要先创建

    JavaBean：
    <jsp:useBean id="user1" class="cn.yunfenglu.domain.User" />
    <jsp:setProperty property="username" name="user1" value="admin"/>
    <jsp:setProperty property="password" name="user1" value="admin123"/>
    用户名：<jsp:getProperty property="username" name="user1"/><br/>
    密　码：<jsp:getProperty property="password" name="user1"/><br/>

