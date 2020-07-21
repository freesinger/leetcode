package src.greedy;

/**
 * 字符串去除K个字符后组成的最大（小）整数
 */
public class RemoveKDigits {
    private static String maxValue(String num, int remove) {
        StringBuilder s = new StringBuilder(num);
        if (num.length() <= remove) return "0";

        for (int i = 0; i < remove; i++) {
            int j = 0;
            while (j < s.length() - 1) {
                if (s.charAt(j) < s.charAt(j + 1)) {
                    break;
                }
                j++;
            }
            s.delete(j, j + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }

        return s.toString();
    }

    private static String minValue(String num, int remove) {
        StringBuilder s = new StringBuilder(num);
        if (num.length() <= remove) return "0";

        for (int i = 0; i < remove; i++) {
            int j = 0;
            while (j < s.length() - 1) {
                if (s.charAt(j) > s.charAt(j + 1)) {
                    break;
                }
                j++;
            }
            s.delete(j, j + 1);
            // 去除头部的0，且要满足长度>1，否则会成为空串
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }

        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println(maxValue("251872694", 4));
        System.out.println(minValue("251872694", 4));
        System.out.println(maxValue("0100", 1));
        System.out.println(minValue("0100", 1));
        System.out.println(maxValue("100", 4));
        System.out.println(minValue("100", 4));
    }
}
