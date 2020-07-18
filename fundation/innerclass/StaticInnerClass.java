package innerclass;

public class StaticInnerClass {
    private static int i = 1;
    private int j = 10;

    /**
     * 静态内部类可以用public,protected,private修饰
     * 静态内部类中可以定义静态或者非静态的成员
     */
    static class Inner {
        private static int inner_i = 100;
        static int i = 2;
        int innerJ = 200;

        static void innerF1() {
            // 静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)
            System.out.println("StaticInnerClass.i: " + StaticInnerClass.i);
            System.out.println(i);
            outerF1();
        }

        void innerF2() {
            // 静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
            // System.out.println("StaticInnerClass.i"+j);
            // outerF2();
            System.out.println(i);
            System.out.println(innerJ);
        }
    }

    public static void outerF1() {
    }

    public void outerF2() {
    }

    public void outerF3() {
        // 外部类访问内部类的静态成员：内部类.静态成员
        System.out.println(Inner.inner_i);
        Inner.innerF1();
        // 外部类访问内部类的非静态成员:实例化内部类即可
        Inner inner = new Inner();
        System.out.println(inner.innerJ);
        inner.innerF2();
    }

    public static void main(String[] args) {
        new StaticInnerClass().outerF3();
    }
}
