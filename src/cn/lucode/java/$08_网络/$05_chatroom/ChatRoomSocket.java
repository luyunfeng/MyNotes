package cn.lucode.java.$08_网络.$05_chatroom;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatRoomSocket {
	DatagramSocket dssend = null;
	DatagramSocket sdreceive = null;
	SendThread st = null;
	ReceiveThread rt = null;
	GuiChatRoom win =null;
	public ChatRoomSocket() throws SocketException {
		// 初始化窗口
		win = new GuiChatRoom();
		dssend = new DatagramSocket();
		sdreceive = new DatagramSocket(10086);
		st = new SendThread(dssend,win);
		rt = new ReceiveThread(sdreceive,win);
		Thread s = new Thread(st);
		Thread r = new Thread(rt);
		s.start();
		r.start();
	}
	
}
