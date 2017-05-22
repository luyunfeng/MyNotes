package cn.lucode.设计模式.$02_单例模式;

/**
 * Created by lucode on 2017/5/11.
 */
public class Main {
    public static void main(String[] args) {
        // 无论创建多少对象 只会有一个实例
//        Singleton_1 singleton = Singleton_1.getInstance();
//        Singleton_1 singleton2 = Singleton_1.getInstance();
        // 双重锁机制 测试
        Singleton_3 singleton = Singleton_3.getInstance();
        Singleton_3 singleton2 = Singleton_3.getInstance();
        System.out.println(singleton==singleton2);

    }


}

/******************懒汉式*********************/
//懒汉式单例类.在第一次调用的时候实例化自己
class Singleton_1 {
    private Singleton_1() {
    }

    private static Singleton_1 single = null;

    //静态工厂方法
    public static Singleton_1 getInstance() {
        if (single == null) {
            single = new Singleton_1();
            System.out.println("第一次调用初始化");
        }
        return single;
    }
}

/*
但是以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，
并发环境下很可能出现多个Singleton实例，要实现线程安全，
有以下三种方式，都是对getInstance这个方法改造，保证了懒汉式单例的线程安全
*/
//1、在getInstance方法上加同步
class Singleton_2 {

    private Singleton_2() {
    }

    private static Singleton_2 single = null;

    //静态工厂方法
    public static synchronized Singleton_2 getInstance() {
        if (single == null) {
            single = new Singleton_2();
        }
        return single;
    }
}

//2、双重锁机制
class Singleton_3 {

    private Singleton_3() {
    }

    private static Singleton_3 single = null;

    public synchronized static Singleton_3 getInstance() {
        if (single == null) {
            synchronized (Singleton_3.class) {
                if (single == null) {
                    single = new Singleton_3();
                    System.out.println("双重锁机制，第一次被加载");
                }
            }
        }
        return single;
    }

}
// 静态内部类
// 这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响。
class Singleton_4 {
    private static class LazyHolder {
        private static final Singleton_4 INSTANCE = new Singleton_4();
    }
    private Singleton_4 (){}
    public static final Singleton_4 getInstance() {
        return LazyHolder.INSTANCE;
    }
}

/******************饿汉式*********************/
//饿汉式单例类.在类初始化时，已经自行实例化
//饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
class Singleton_5 {
    private Singleton_5() {}
    private static final Singleton_5 single = new Singleton_5();
    //静态工厂方法
    public static Singleton_5 getInstance() {
        return single;
    }
}


