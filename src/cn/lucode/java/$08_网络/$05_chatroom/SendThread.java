package cn.lucode.java.$08_网络.$05_chatroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class SendThread implements Runnable {
	private DatagramSocket dssend;
	private GuiChatRoom win;

	public SendThread(DatagramSocket dssend, GuiChatRoom win) {
		this.dssend = dssend;
		this.win = win;
	}

	@Override
	public void run() {

		win.b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				byte[] buf = win.field.getText().getBytes();
				DatagramPacket dp = null;
				try {
					
					/*dp = new DatagramPacket(buf, buf.length, InetAddress
							.getByName("139.129.92.253"), 10086);	*/		
					dp = new DatagramPacket(buf, buf.length, InetAddress
							.getByName("127.0.0.1"), 10086);
					dssend.send(dp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				win.area.append("me:" + "\r\n"+win.field.getText() + "\r\n");
				win.field.setText("");
				
			}
		});

	}

}
