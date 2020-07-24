package threadlocal;

public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> INTEGER_THREAD_LOCAL = ThreadLocal.withInitial(() -> 0);

    private static void incrementByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            try {
                Integer n = INTEGER_THREAD_LOCAL.get();
                n++;
                INTEGER_THREAD_LOCAL.set(n);
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ": ThreadLocal num = " + INTEGER_THREAD_LOCAL.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(ThreadLocalDemo::incrementByThreadLocal).start();
        }
    }
}
