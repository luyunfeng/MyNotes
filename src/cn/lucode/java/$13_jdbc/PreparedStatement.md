### 介绍
* 它是Statement接口的子接口；
* 强大之处：

> 防SQL攻击； (预编译处理)

> 提高代码的可读性、可维护性；

> 提高效率！  
 
可以使用PreparedStatement来替换Statement。   

```java
// 给出 sql 模板
String sql = “select * from tab_student where s_number=?”;
// 得到 PreparedStatement对象,并绑定模板
PreparedStatement pstmt = con.prepareStatement(sql);
// 往模板里面放参数
pstmt.setString(1, “S_1001”);
// 开始查
ResultSet rs = pstmt.executeQuery();
// 记得查完就关闭
rs.close();
// 第二次用的时候 记得清除一次啊
pstmt.clearParameters();
// 再次查询
pstmt.setString(1, “S_1002”);
rs = pstmt.executeQuery();

```
