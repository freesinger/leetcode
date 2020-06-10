package src.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tools {
    private static Logger logger = LoggerFactory.getLogger(Tools.class);

    public static void traceArray(int[] A) {
        try {
            for (int i : A)
                System.out.print(i + " "); // ' ' 会导致' '值和相加
            System.out.println();
        } catch (Exception e) {
            logger.error("Trace array failed!");
            e.printStackTrace();
        }
    }

    /**
     * 引用类型才可以使用泛型, primitive类型不可以
     *
     * @param A
     * @param <T>
     */
    public static <T> void traceArray(T[] A) {
        try {
            for (T i : A) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        } catch (Exception e) {
            logger.error("Parse array failed!");
            e.printStackTrace();
        }
    }

    public static void swapByIndex(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void traceList(List<T> list) {
        try {
            for (T element : list) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.println();
        } catch (Exception e) {
            logger.error("Parse list failed!");
            e.printStackTrace();
        }
    }

    public static List<Integer> intArrayToList(int[] intArray) {
        if (intArray == null) {
            logger.error("Array is null");
            return null;
        }
        return Arrays.stream(intArray).boxed().collect(Collectors.toList());
    }

    public static List<Character> charArrayToList(char[] charArray) {
        List<Character> characterList = new ArrayList<>();
        for (char ch : charArray) characterList.add(ch);
        return characterList;
    }

    public static int factorial(int num) {
        if (num < 0) throw new ArithmeticException("Illegal number < 0!");
        int res = 1;
        while (num > 1) {
            res *= num;
            num--;
        }
        return num == 0 ? 0 : res;
    }
}
