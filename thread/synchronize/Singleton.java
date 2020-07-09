package synchronize;


/**
 * DCL实现Singleton
 */
public class Singleton {
    // volatile禁止jvm指令重排，使得 singletonInstance = new Singleton();
    // 分配内存空间 -> 初始化 -> 指向内存地址 能够正常完成
    private volatile static Singleton singletonInstance;

    // private只有自己能实例化自己
    private Singleton() {
    }

    public static Singleton getInstance() {
        // 未实例化才进入锁代码，已创建则直接返回提高性能
        if (singletonInstance == null) {
            // 类锁，只有一个线程获得实例权
            synchronized (Singleton.class) {
                // 阻塞线程到这里需要再次判断是否已实例化，防止重复创建
                if (singletonInstance == null) {
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }
}
