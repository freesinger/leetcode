package threadlocal;

public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> INTEGER_THREAD_LOCAL = ThreadLocal.withInitial(() -> 0);

    private static void incrementByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            Integer n = INTEGER_THREAD_LOCAL.get();
            n++;
            INTEGER_THREAD_LOCAL.set(n);
            System.out.println(Thread.currentThread().getName() + ": ThreadLocal num = " + INTEGER_THREAD_LOCAL.get());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(ThreadLocalDemo::incrementByThreadLocal);
            t.start();
        }
    }
}
