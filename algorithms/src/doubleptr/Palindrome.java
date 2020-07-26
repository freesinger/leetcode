package src.doubleptr;

/**
 * 最长回文串
 */
public class Palindrome {
    public String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public String longestPalindrome(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            String r1 = getPalindrome(str, i, i);
            String r2 = getPalindrome(str, i, i + 1);
            result = r1.length() > result.length() ? r1 : result;
            result = r2.length() > result.length() ? r2 : result;
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println("abcbd".substring(1, 3)); "ab"
        System.out.println(new Palindrome().longestPalindrome("abcbd"));
    }
}
