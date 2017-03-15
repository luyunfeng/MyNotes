File类的基本用法
===================
### 基本获取功能
```java
    public String getAbsolutePath()
    public String getPath()
    public String getName()
    public long length()
    public long lastModified()//最后修改时间
```

----------------------
### 高级获取功能（文件过滤器）
```java
    public String[] list()
    public File[] listFiles()
```
----------------------
```java
 public class FileDemo {
	public static void main(String[] args) {
		File f = new File("d:\\视屏学习");
		//1. 遍历文件
		// 单纯想获取文件名可以使用f.list()返回值为String[]
		File[] list = f.listFiles();
		// 一般采用增强for循环
		for (File file : list) {
			// 遍历文件夹和文件
			System.out.println(file.getName());
		}
		System.out.println("---------");
		for (File file : list) {
			// 相当于遍历一个文件夹的文件和文件返回它的绝对路径
			// public File getAbsoluteFile()
			System.out.println(file.getAbsoluteFile());
		}
	}
    }
```