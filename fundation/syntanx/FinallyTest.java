package syntanx;

public class FinallyTest {
    public static void main(String[] args) {
        // test();
        test2();
        //test3();
    }

    public static String test() {
        String str = null;
        int i = 0;
        if (i == 0) {
            return str;//直接返回未执行到finally语句块
        }
        try {
            System.out.println("try...");
            return str;
        } finally {
            System.out.println("finally...");
        }
    }

    public static String test2() {
        String str = null;
        int i = 0;
        i = i / 0;//抛出异常未执行到finally语句块
        try {
            System.out.println("try...");
            return str;
        } finally {
            System.out.println("finally...");
        }
    }

    public static String test3() {
        String str = null;
        try {
            System.out.println("try...");
            System.exit(0);//系统退出未执行到finally语句块
            return str;
        } finally {
            System.out.println("finally...");
        }
    }
}
