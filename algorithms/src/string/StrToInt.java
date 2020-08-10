package src.string;

/**
 * 字符串转换为整数
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(convert("-23141241"));
        System.out.println(convert("1dad"));
    }

    private static int convert(String str) {
        boolean isNegative = false;
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch =  str.charAt(i);
            if (i == 0 && (ch == '-' || ch == '+')) {
                isNegative = ch == '-';
                continue;
            }
            if (ch < '0' || ch > '9') return 0;
            sum = (ch - '0') + 10 * sum;
        }

        return isNegative ? -sum : sum;
    }
}
