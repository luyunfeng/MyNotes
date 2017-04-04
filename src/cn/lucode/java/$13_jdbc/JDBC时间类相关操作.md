JDBC时间类相关操作
==========================
#### 数据库类型与java中类型的对应关系：
    DATE -- java.sql.Date
    TIME --java.sql.Time
    TIMESTAMP -- java.sql.Timestamp

#### java.sql包下给出三个与数据库相关的日期时间类型，分别是：
>	Date：表示日期，只有年月日，没有时分秒。会丢失时间；
>	
>	Time：表示时间，只有时分秒，没有年月日。会丢失日期；
>	
>	Timestamp：表示时间戳，有年月日时分秒，以及毫秒。

这三个类都是java.util.Date的子类。

所以有这样sql中的转换到util直接赋值，反过来转换需要创建对象

### 1.创建数据库
>    CREATE TABLE dt(d DATE,t TIME,ts TIMESTAMP)

### 2.插数据

    @Test
	public void fun1() throws SQLException {
		Connection con = JdbcUtils.getConnection();
		String sql = "insert into dt value(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		java.util.Date d = new java.util.Date();
		pstmt.setDate(1, new java.sql.Date(d.getTime()));
        //2016-03-16
		pstmt.setTime(2, new Time(d.getTime()));
        //21:45:33
		pstmt.setTimestamp(3, new Timestamp(d.getTime()));
        //2016-03-16 21:45:33
		pstmt.executeUpdate();
	}

### 3.查询

    @Test
	public void fun2() throws SQLException {
		Connection con = JdbcUtils.getConnection();
		String sql = "select * from dt";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		java.util.Date d1 = rs.getDate(1);
		java.util.Date d2 = rs.getTime(2);
		java.util.Date d3 = rs.getTimestamp(3);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}

    