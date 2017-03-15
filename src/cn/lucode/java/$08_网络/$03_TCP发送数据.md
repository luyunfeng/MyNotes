网络编程——TCP发送数据
===============
**TCP发送数据遵循三次握手所以必须服务器端先开启准备接收数据**


###  服务器端

    public class ServerDemo {
	/*
	 * 服务器端 
	 * 1.得到服务器端的Socket 
	 * 2.转变成Socket对象 
	 * 3.输入流 
	 * 4.关闭（服务器的Socket不要关）
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10086);
		Socket s = ss.accept();// 得到服务器的Socket
		InputStream is = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		String str = new String(buf, 0, len);
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "----" + str);
		// ss.close();//不能关闭服务器
		s.close();
	}
    }

###  客户端

    public class ClientDemo {
	/**
	 * 1.socket对象 
	 * 2.输出流 
	 * 3.关闭资源
	 */
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.1.100", 10086);
		OutputStream os = s.getOutputStream();
		os.write("233".getBytes());
		s.close();
	}
    }