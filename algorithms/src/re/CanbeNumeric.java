package src.re;

/**
 * []  ： 字符集合
 * ()  ： 分组
 * ?   ： 重复 0 ~ 1 次
 * +   ： 重复 1 ~ n 次
 * *   ： 重复 0 ~ n 次
 * .   ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 */
public class CanbeNumeric {
    public boolean isNumeirc(String str) {
        if (str == null || str.length() == 0) return false;
        return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
