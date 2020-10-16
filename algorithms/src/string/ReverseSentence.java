package src.string;

/**
 * 翻转单次顺序列
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseSentence("I am a student.")); // student. a am I
        System.out.println(reverseSentence("Shane is studying in THU"));
    }

    private static String reverseSentence(String str) {
        char[] chs = str.toCharArray();
        int i = 0, j = 0;

        // EOL判断需要加=
        while (j <= str.length()) {
            if (j == str.length() || chs[j] == ' ') {
                reverseAndCase(chs, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        // System.out.println(Arrays.toString(chs));
        reverse(chs, 0, str.length() - 1);

        return new String(chs);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
    }

    // 大小写互转注意奇数长度字符需要=
    private static void reverseAndCase(char[] chars, int start, int end) {
        while (start <= end) {
            char l = Character.isLowerCase(chars[start]) ? Character.toUpperCase(chars[start]) : Character.toLowerCase(chars[start]);
            char r = Character.isLowerCase(chars[end]) ? Character.toUpperCase(chars[end]) : Character.toLowerCase(chars[end]);
            chars[start] = r;
            chars[end] = l;
            start++;
            end--;
        }
    }
}
