package 学而思;

/*
    用递归算法判断字符串是否满足如下特性：字符串倒过来和原来字符串一样，如xueersiisreeux满足，xueersiisrexux不满足。

    输入
    1：输入 xueersiisreeux
    2：输入 xueersiisreeuu

    输出
    1：输出1
    2：输出0

    样例输入
    xueersiisreeux
    样例输出
    1
 */

public class 用递归算法判断字符串特性 {
    public int isReverseSame(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if (left >= right) {
            return 1;
        } else {
            return 0;
        }
    }
}
