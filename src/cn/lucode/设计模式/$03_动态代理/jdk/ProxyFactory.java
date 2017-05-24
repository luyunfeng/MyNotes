package cn.lucode.设计模式.$03_动态代理.jdk;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lucode on 2017/5/23.
 */
public class ProxyFactory {
    //给代理对象生成实例对象
    public static Object getProxyInstance(Object target) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("事务开启");

                        // 执行目标 对象方法
                        Object obj = method.invoke(target, args);
                        System.out.println("提交事务");
                        return obj;
                    }
                }
        );
    }

    // 使用Lambda 表达式改写
    public static Object getProxyInstance2(Object target) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("Lambda事务开启");
                    // 执行目标 对象方法
                    Object obj = method.invoke(target, args);
                    System.out.println("Lambda提交事务");
                    return obj;

                }
        );
    }
}
