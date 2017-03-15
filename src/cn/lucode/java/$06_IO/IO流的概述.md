IO基本概述
================
### IO流分类

按照流向

>输入流：读取数据

>输出流：写出数据

**相对于程序而言来说**

------------------
###  按照数据类型

>字节流   （万能流）

>字符流  （处理文本文件）

字节流的抽象基类：
>InputStream（读取数据）

>OutputStream（写出数据）

字符流的抽象基类：
>Reader （读取数据）

> Writer（写出数据）


区别：操作的时候**能用记事本打开读懂的就是字符流**，反之字节流

比如word文件就是需要用字节流传输的


##  字节流读文件
```java
  public class Demo01 {
	public static void main(String[] args) throws IOException {
		// 1.建立文件联系 项目的下的相对路径写法 注意
		// a.txt在项目下 不是src下
		File src = new File("file/a.txt");
		// 2.选择流
		InputStream in = new FileInputStream(src);
		// 3.缓冲数组
		byte[] buf = new byte[1024];
		int len = 0;
		//4.循环写出，没有数据返回-1，表示退出
		while (-1 != (len = in.read(buf))) {
			String s = new String(buf, 0, len);
			System.out.println(s);
		}
		//关闭资源
		in.close();
	}
    }
```
##  字节流写文件
```java
  public class Demo02 {
	public static void main(String[] args) throws IOException {
		File src = new File("file/a.txt");
		OutputStream out = new FileOutputStream(src, true);
		//这里选择字节流
		byte[] buf = new byte[10];
		String str = "这句话写入文件！！\r\n";
		//转成byte
		buf = str.getBytes();
		out.write(buf, 0, buf.length);
		// 强制刷新出去
		out.flush();
		out.close();
	}
    }
```
  
    
    
    
