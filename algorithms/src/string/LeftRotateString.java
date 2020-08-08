package src.string;

/**
 * 左旋转字符串
 *
 */
public class LeftRotateString {
    public static void main(String[] args) {
        LeftRotateString test = new LeftRotateString();
        System.out.println(test.rotateString("abcXYZdef", 3));
    }

    public String rotateString(String str, int k) {
        char[] chs = str.toCharArray();
        reverse(chs, 0, k - 1);
        reverse(chs, k, str.length() - 1);
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }
}
