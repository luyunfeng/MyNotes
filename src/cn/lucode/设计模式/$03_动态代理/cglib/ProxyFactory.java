package cn.lucode.设计模式.$03_动态代理.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lucode on 2017/5/24.
 */
public class ProxyFactory implements MethodInterceptor{
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

     // 得到目标对象的 代理对象 实例
    public Object getProxyInstance(){

        //1. 工具类
        Enhancer enhancer=new Enhancer();
        // 2. 设置父类
        enhancer.setSuperclass(this.target.getClass());
        // 3. 回调函数
        enhancer.setCallback(this);
        // 4.创建 并返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开启");
        Object obj=method.invoke(this.target,objects);
        System.out.println("事务结束");
        return obj;
    }
}
