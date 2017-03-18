Frame窗口实现（适配器模式介绍）
========================
##  问题：
一个接口存在多个方法，当需要用这个接口的时候（匿名内部类实现）
我们需要把这个接口的方法都实现，但是很多方法我们并需要，那么该怎么办呢？
##  适配器模式解决：
   先用抽象类继承这个接口，把里面的方法==空实现==，然后在用的时候创建匿名内部类该抽象方法，要用什么方法我们实现什么方法。

 **注意：**

  *  接口里面都是抽象方法，所以必须都要实现
  *  抽象类中可以有具体的方法


##  简单窗口实现

Frame f=new Frame();

* 设置窗体标题:f.setTitle("HelloWorld");
* 设置窗体大小:f.setSize(400, 300); // 单位：像素
* 设置窗体位置:f.setLocation(400, 200);
* 同时设置窗口大小和位置:f.setBounds(400, 200, 400, 300);
* 关闭窗口(这里就是适配器模式的体现)：
   > 窗口关闭的WindowListener接口里面有一个方法windowClosing(WindowEvent e)，直接匿名内部类完成实现
   > 但是是接口所以我们需要把所有的方法实现才能
   > 这时，就要用到一个设计模式**适配器模式**
   > 调用WindowListener接口的实现类WindowAdapter，完成关闭


    public class FrameDemo {
	public static void main(String[] args) {
		Frame f=new Frame("英雄联盟");
        f.setBounds(400, 200, 400, 300);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
		});
	} }



