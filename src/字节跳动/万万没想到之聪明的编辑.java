package 字节跳动;

/*  万万没想到之聪明的编辑
    我发现一个发现拼写错误的捷径：

    1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
    2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
    3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC

    请听题：请实现大锤的自动校对程序

    输入描述：
    第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
    后面跟随N行，每行为一个待校验的字符串。

    输出描述：
    N行，每行包括一个被修复后的字符串。

    输入例子：
    2
    helloo
    wooooooow

    输出例子：
    hello
    woow
 */

import java.util.Scanner;
//  遍历一遍字符串，碰到 3 个连续相同的字符或者 AABB 就将当前字符删去即可
public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        while (N-- > 0) {
            String s = sc.nextLine();

            StringBuilder sb = new StringBuilder(s);
            for (int i = 2; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1) && sb.charAt(i - 1) == sb.charAt(i - 2)) {
                    sb.deleteCharAt(i);
                    i--;
                } else if (isPattern(sb, i - 3, i)) {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean isPattern(StringBuilder sb, int i, int j) {
        if (i < 0) return false;
        return sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(j - 1) == sb.charAt(j);
    }
}
