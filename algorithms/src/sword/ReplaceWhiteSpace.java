package src.sword;

/**
 * 将一个字符串中的空格替换成 "%20"。
 */

class ReplaceWhiteSpace {
    /**
     * 遍历添加所需长度，双指针反向填充
     */
    public String replaceSpace(StringBuffer str) {
        int ptr = str.length()-1;
        for (int i = 0; i <= ptr; i++) {
            if (str.charAt(i) == ' ') str.append("   ");
        }

        int ptr2 = str.length()-1;
        while (ptr2 > ptr && ptr >= 0) {
            if (str.charAt(ptr) == ' ') {
                str.setCharAt(ptr2--, '0');
                str.setCharAt(ptr2--, '2');
                str.setCharAt(ptr2--, '%');
            } else {
                str.setCharAt(ptr2--, str.charAt(ptr));
            }
            ptr--;
        }

        return str.toString();
    }
}