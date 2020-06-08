package src.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tools {
    public static void traceArray(int[] A) {
        for (int i : A)
            System.out.print(i + " "); // ' ' 会导致' '值和相加
        System.out.println();
    }

    /**
     * 引用类型才可以使用泛型, primitive类型不可以
     * @param A
     * @param <T>
     */
    public static <T> void traceArray(T[] A) {
        for (T i : A) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void swapByIndex(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void traceList(List<T> list) {
        for (T element : list) {
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static List<Integer> intArrayToList(int[] intArray) {
        return Arrays.stream(intArray).boxed().collect(Collectors.toList());
    }

    public static List<Character> charArrayToList(char[] charArray) {
        List<Character> characterList = new ArrayList<>();
        for (char ch : charArray) characterList.add(ch);
        return characterList;
    }
}
