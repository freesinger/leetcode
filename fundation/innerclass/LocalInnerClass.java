package innerclass;

public class LocalInnerClass {
    private int s = 100;
    private int outI = 1;

    public static void main(String[] args) {
        // 访问局部内部类必须先有外部类对象
        LocalInnerClass out = new LocalInnerClass();
        out.f();
    }

    public void f() {
        final int s = 200;
        int i = 1;
        final int j = 10;


        /**
         * 定义在方法内部
         */
        class Inner {
            // 可以定义与外部类同名的变量
            int s = 300;
            int innerI = 100;

            // static int m = 20; 不可以定义静态变量
            private Inner() {
                innerF();
            }

            private void innerF() {
                // java如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的全局变量
                System.out.println(outI);
                // 可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的
                System.out.println(j);
                //System.out.println(i);
                // 如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量
                System.out.println(s);
                // 用this.变量名访问的也是内部类变量
                System.out.println(this.s);
                // 用外部类名.this.内部类变量名访问的是外部类变量
                System.out.println(LocalInnerClass.this.s);
            }
        }

        new Inner();
    }
}
