package cn.lucode.设计模式.$03_动态代理.jdk;

/**
 * Created by lucode on 2017/5/23.
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("开始保存");
    }
}
