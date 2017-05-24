package cn.lucode.设计模式.$03_动态代理.cglib;

/**
 * Created by lucode on 2017/5/24.
 */
public class Main {
    public static void main(String[] args) {
        /*
        * 采用 cglib 代理  不需要实现接口
        *
        * */
        UserDao userDao = new UserDao();
        UserDao proxy = (UserDao) new ProxyFactory(userDao).getProxyInstance();
        proxy.save();

    }
}
