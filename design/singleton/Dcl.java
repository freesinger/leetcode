package singleton;

/**
 * Notes:
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 * <p>
 * Double-checked locking
 */
public class Dcl {
    // volatile here && private
    private volatile static Dcl dcl;

    private Dcl() {
    }

    public static Dcl getInstance() {
        if (dcl == null) {
            // synchronize保证同一时间只有一个线程能取单例的实例
            synchronized (Dcl.class) {
                if (dcl == null) {
                    // 当多个线程同时访问时，有一个线程创建了实例则dcl强制写回共享内存（!=null）
                    // 其他线程只能等锁来访问而无法再创建新的单例
                    dcl = new Dcl();
                }
            }
        }
        return dcl;
    }
}
