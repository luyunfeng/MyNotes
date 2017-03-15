package cn.lucode.java.$08_网络.$04_Demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lucode on 2017/3/14.
 */
public class Send_UDP {
    public static void main(String[] args) throws IOException {
        Frame f = new Frame("发送端");
        f.setBounds(350, 200, 400, 300);
        f.setLayout(new FlowLayout());
        final TextArea area = new TextArea(20, 40);
        Button b = new Button("发送");
        f.add(area);
        f.add(b);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
        final DatagramSocket ds =new DatagramSocket();
        //创建按钮监听
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                byte[] buf = area.getText().getBytes();
                DatagramPacket dp = null;
                try {

                    //
                    dp = new DatagramPacket(buf, buf.length, InetAddress
                            .getByName("127.0.0.1"), 10000);
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    ds.send(dp);
                    System.out.println("has send"+area.getText());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

    }
}
