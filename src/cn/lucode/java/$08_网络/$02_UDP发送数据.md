UDP 发送数据
==========================
### 接收端
```java
public class Receive_UDPDemo {
	public static void main(String[] args) throws IOException {
		// 1.套接字对象
		DatagramSocket ds = new DatagramSocket(10086);
		// 2.准备接收数据
		byte[] buf = new byte[1024];
		int length = buf.length;
		DatagramPacket dp = new DatagramPacket(buf, length);
		// 接收数据
		ds.receive(dp);
		//3.开始 解析数据
		// 得到ip
		InetAddress address = dp.getAddress();
		String ip = address.getHostAddress();
        //得到数据
		byte[] buf2 = dp.getData();
		int length2 = dp.getLength();
		String s = new String(buf2, 0, length2);
		System.out.println(ip + "***" + s);
        // 4.关闭
		ds.close();
	}
}
```
### 发送端
```java
public class Send_UDPDemo {

	public static void main(String[] args) throws IOException {
		//1. 发送端创建Socket对象
		DatagramSocket ds = new DatagramSocket();
		// 2.准备参数然后 数据打包
		byte[] buf = "23333".getBytes();
		int length = buf.length;
		InetAddress address = InetAddress.getByName("192.168.1.101");
		int port = 10000;
		DatagramPacket dp = new DatagramPacket(buf, length, address, port);
		// 3.发送
		ds.send(dp);
		//4. 关闭
		ds.close();
	}
    }
```
## 简单界面的程序
见 $04_Demo