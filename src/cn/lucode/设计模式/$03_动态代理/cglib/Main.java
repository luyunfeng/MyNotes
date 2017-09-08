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
        //class cn.lucode.设计模式.$03_动态代理.cglib.UserDao
        System.out.println(userDao.getClass());
        UserDao proxy = (UserDao) new ProxyFactory(userDao).getProxyInstance();
        // 看打印结果 出现 EnhancerByCGLIB 表示采用 cglib 动态代理
        // class cn.lucode.设计模式.$03_动态代理.cglib.UserDao$$EnhancerByCGLIB$$bf9bc481
        System.out.println(proxy.getClass());
        proxy.save();

    }
}
