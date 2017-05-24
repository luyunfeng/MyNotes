package cn.lucode.设计模式.$03_动态代理.jdk;

/**
 * Created by lucode on 2017/5/23.
 */
public class Main {
    public static void main(String[] args) {
        UserDao userDao=new UserDaoImpl();
        // 工厂方法 把目标 传入工厂方法之中
        UserDao userDaoProxy=(UserDao) ProxyFactory.getProxyInstance2(userDao);
        // 调用代理后的  方法
        userDaoProxy.save();
    }
}
