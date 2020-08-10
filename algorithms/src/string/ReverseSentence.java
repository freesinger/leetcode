package src.string;

/**
 * 翻转单次顺序列
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseSentence("I am a student.")); // student. a am I
    }

    private static String reverseSentence(String str) {
        char[] chs = str.toCharArray();
        int i = 0, j = 0;

        // EOL判断需要加=
        while (j <= str.length()) {
            if (j == str.length() || chs[j] == ' ') {
                reverse(chs, i, j - 1);
                i = j + 1;
            }
            j++;
        }
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
}
