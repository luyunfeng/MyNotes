package cn.lucode.java.$08_网络;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lucode on 2017/7/20.
 */
public class $06_IP {
    private static String ip_address = null;
    static {
        try {
            ip_address = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ip_address);
    }

}
