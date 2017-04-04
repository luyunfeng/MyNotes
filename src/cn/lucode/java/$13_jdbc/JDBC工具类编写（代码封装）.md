JDBC工具类的编写（封装代码）
============================

#### 下面是创建一个静态的getConnection类返回值是Connection类型

1. 首先建立配置文件（一般放在res下面目录）
    >新建文件 &nbsp;dbconfig.properties &nbsp; 输入四大参数
  
2. 加载配置文件
    
    > InputStream in=jdbc_tool.class.getClassLoader().getResourceAsStream("dbconfig.properties");

      >Properties pro=new Properties();

    > pro.load(in);
3. 同样加载驱动
    >Class.forName(pro.getProperty("DriverClassName"));  	 

4. 返回值返回Connection对象
    >return DriverManager.getConnection(url,user.password);
   
#### 简单代码演示
    ` static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
    	 /*
    	  * 1.加载配置文件
    	  * 2.加载驱动类
    	  * 3.调用驱动类
    	  * 4.返回Connection 
    	  * */
    	  InputStream in=jdbc_tool.class.getClassLoader()
    			  .getResourceAsStream("dbconfig.properties");
    	  Properties pro=new Properties();
    	  pro.load(in);
    	  Class.forName(pro.getProperty("DriverClassName"));  	 
    	 return DriverManager.getConnection(pro.getProperty("url"),
    			 pro.getProperty("user"),pro.getProperty("password"));
    	 
     }`
#### 标准代码
    import java.io.IOException;
    import java.io.InputStream;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.util.Properties;
    public class JdbcUtils {
	private static Properties props = null;
	
	  // 只在JdbcUtils类被加载时执行一次！
	static {
		// 给props进行初始化，即加载dbconfig.properties文件到props对象中
		try {
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
		
		// 加载驱动类
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	// 获取连接!
	public static Connection getConnection() throws SQLException {
		// 得到Connection
		return DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"), 
				props.getProperty("password"));
	  }
    }
