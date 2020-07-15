package innerclass;

public class MemberInnerClass {
    private static int i = 1;
    private int j = 10;
    private int k = 20;

    /**
     * 成员内部类中，不能定义静态成员
     * 成员内部类中，可以访问外部类的所有成员
     */
    class Inner {
        // static int innerI = 100;内部类中不允许定义静态变量(静态内部类才可以)
        // 内部类和外部类的实例变量可以共存
        int j = 100;
        int i = 999;
        // static int innerI = 1;

        Inner() {}

        Inner(int j, int i) {
            this.j = j;
            this.i = i;
        }

        void innerF1() {
            // 优先访问内部类局部变量
            System.out.println(i);
            // 访问外部类的静态变量
            System.out.println(MemberInnerClass.i);
            // 在内部类中访问内部类自己的变量直接用变量名
            System.out.println(j);
            // 在内部类中访问内部类自己的变量也可以用this.变量名
            System.out.println(this.j);
            // 在内部类中访问外部类中与内部类同名的实例变量用外部类名.this.变量名
            System.out.println(MemberInnerClass.this.j);
            // 如果内部类中没有与外部类同名的变量，则可以直接用变量名访问外部类变量
            System.out.println(k);
            outerF1();
            outerF2();
            System.out.println();
        }
    }

    /**
     * 成员内部类可以访问外部类静态方法
     */
    public static void outerF1() {
    }

    /**
     * 成员变量可以访问外部类非静态方法
     */
    public void outerF2() {
    }

    /**
     * 外部类的非静态方法访问成员内部类
     */
    public void outerF3() {
        Inner inner = new Inner();
        inner.innerF1();
    }

    /**
     * 外部类的静态方法访问成员内部类，与在外部类外部访问成员内部类一样
     */
    public static void outerF4() {
        //step1 建立外部类对象
        MemberInnerClass out = new MemberInnerClass();
        //step2 根据外部类对象建立内部类对象
        Inner inner = out.new Inner(666, 888);
        //step3 访问内部类的方法
        inner.innerF1();
    }

    public static void main(String[] args) {
        MemberInnerClass out = new MemberInnerClass();
        out.outerF3();
        MemberInnerClass.outerF4();
        MemberInnerClass.Inner outin = out.new Inner();
        outin.innerF1();
    }
}
