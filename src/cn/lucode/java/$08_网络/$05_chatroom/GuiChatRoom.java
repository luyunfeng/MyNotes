package cn.lucode.java.$08_网络.$05_chatroom;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class GuiChatRoom extends Frame {
    TextArea area = new TextArea(13, 40);
    TextField field = new TextField(20);
    Button b = new Button("发送");

    public GuiChatRoom() {
        this.setSize(400, 300);
        WinCenter.center(this);
        this.setTitle("窗口");
        this.setLayout(new FlowLayout());

        this.add(area);
        this.add(field);
        this.add(b);
        this.setResizable(false);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


}    
