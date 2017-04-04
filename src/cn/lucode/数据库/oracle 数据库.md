# oracle 数据库基本操作
### 登陆工具sqlplus(命令行)
* sqlplus  / as  sysdba  斜杠后和as要留空格

这样写直接用最高管理员身份进入  
> sqlplus  sys/dba

> sqlplus  用户名/密码

### 修改用户密码和解锁用户
> 以sys超级用户名，dba角色，即超级管理员身份解锁scott方案/用户，并为scott设置一个密码为123456


> 解锁用户：alter user scott account unlock;

> 设置密码：alter user scott identified by 123456; 
 普通用户scott
 密码123456
 
> 需要修改当前用户密码时直接在上面输入password就可以

注意 语句执行需要一个一个了；

### 常用命令
* 退出sqlplus工具
> exit

* 查询当前用户是谁 		
> show user;

* 设置显示的列宽（字符型varchar2、日期型date），10个宽度位，a表示字符型，大小写均可

```
column ename format a12;
column hiredate format a10;
```


* 设置显示的列宽（数值型number），9表示数字型，一个9表示一个数字位，四个9表示四个数字位，只能用9

 
```
column empno format 9999;
 column mgr format 9999;
 column sal format 9999;
 column comm format 9999;
 column deptno format 9999;
```

* 设置一页显示80个条记录的高度
> set pagesize 80;

* 使用/杠，执行最近一次的SQL语句
> /

* 清屏，属于SQL*PLUS工具中的命令
> host cls;    
> linux 下clear screen

### 查询
1.查询emp表的结构
> desc emp;

2.查询emp表的所有内容，*号表示通配符，表示该表中的所有字段，但*号不能和具体字段一起使用


```
select * from emp;
或
select empno,ename,sal,deptno from emp;
```

3.查询emp表的员工编号，姓名，工资，部门号，列名，大小写不敏感，但提倡大写，”这里面是别名”   区别名的as可以省略

>select empno "编号",ename  as "姓名",sal "工资",deptNO "部门号" FROM Emp;

4. 查询emp表的不重复的工作
> select distinct job from emp;

5. 查询员工的编号，姓名，月薪，年薪（月薪*12)可以直接进行四则运算
> select empno,ename,sal,sal*12 "年薪" from emp;

6. 查询员工的编号，姓名，入职时间，月薪，年薪，年收入（年薪+奖金)
> select empno "编号",ename"姓名",hiredate "入职时间",sal "月薪",sal*12 "年薪",sal*12+comm "年收入" from emp;


```
如果结果为null，在sqlplus客户端工具中，是不显示null这个值的.
解决null的问题，使用NVL()函数，NVL(a,b)
解释:如果a是NULL，用b替代;如果a是非NULL，就不用b替代，直接返回a的值
select NVL(null,10) from emp;结果有14行记录
select NVL(null,10) from dual;结果有1行记录
select empno "编号",ename"姓名",hiredate "入职时间",sal "月薪",sal*12 "年薪",sal*12+NVL(comm,0) "年收入" 
from emp;
注意：null与具体数字运算时，结果为null
```

7.使用列别名，查询员工的编号，姓名，月薪，年薪，年收入（年薪+奖金)，AS大小写都可且可以省略AS，别名用双引号

```
select empno AS "编号",ename as "姓名",sal "月薪" 
from emp;
或
select empno AS 编号,ename as 姓名,sal 月薪 
from emp;

区别:
select empno AS "编号",ename as 姓名,sal "月    薪" 
from emp;
不加双引号的别名不能有空格；加了双引号的别名可以有空格
要加只能加双引号，不能加单引号，因为在oracle中单引号表示字符串类型或者是日期类型
列名不能使用单引号，因为oracle认为单引号是字符串型或日期型
```

8. dual哑表或者伪表  一般我就用作单行显示东西

9. 使用sysdate，显示系统当前时间，在默认情况下，oracle只显示日期，而不显示时间，格式：26-4月-15
> select sysdate from dual;


10.使用spool命令，保存SQL语句到硬盘文件e:/oracle-day01.sql，并创建sql文件

> spool e:/oracle-day01.sql;

使用spool off命令，保存SQL语句到硬盘文件e:/oracle-day01.sql，并创建sql文件，结束语句

> spool off;

11.使用@命令，将硬盘文件e:/crm.sql，读到orcl实例中，并执行文件中的sql语句
> @ e:/crm.sql;

