package cn.lucode.java.$08_网络.$05_chatroom;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveThread implements Runnable {
	private DatagramSocket dsrecevie;
	private GuiChatRoom win;

	public ReceiveThread(DatagramSocket dsrecevie, GuiChatRoom win) {
		this.dsrecevie = dsrecevie;
		this.win = win;
	}

	@Override
	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				dsrecevie.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			InetAddress address = dp.getAddress();
			String ip = address.getHostAddress();

			byte[] buf2 = dp.getData();
			int length2 = dp.getLength();
			String s = new String(buf2, 0, length2);
			win.area.append("from:" + ip + "\r\n" + s + "\r\n");
			

		}
	}

}
