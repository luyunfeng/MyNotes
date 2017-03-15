package cn.lucode.java.$08_网络.$04_Demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by lucode on 2017/3/14.
 */
public class Receive_UDP {
    public static void main(String[] args) throws IOException {
        Frame f = new Frame("接收端");
        f.setBounds(350, 200, 400, 300);
        TextArea area = new TextArea(20, 40);
        f.add(area);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);


        DatagramSocket ds = new DatagramSocket(10000);
        while (true) {

            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            ds.receive(dp);
            System.out.println("has recevie");
            // 解析数据
            String ip = dp.getAddress().getHostAddress();
            String s = new String(dp.getData(), 0, dp.getData().length);

            area.setText("from:" + ip + "---->" + s + "\r\n");
        }
    }
}
