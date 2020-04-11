package 美团;

/*  字符串最长公共前缀
    输入 n 个字符串（1<=n<=3*10^2，字符串总长度不超过10^3，只包含小写字母）
    后面多次查询，每次查询输入两个数字x, y，输出第 x 个字符串和第 y 个字符串的最长公共前缀长度。（查询次数不超过10^2）

    输入描述：
    第 1 行输入一个整数 n，代表字符串数量；
    第 2~n+1 行，每行一个字符串；
    第 n+2 行开始，每行输入两个整数 a 和 b，代表需要计算公共前缀的字符串编号。

    输出描述：
    每次查询输出一行一个整数，表示两个字符串的最长公共前缀的长度

    输入例子：
    2
    abc
    abe
    1 2
    输出例子：
    2
 */

import java.util.Scanner;

public class 字符串最长公共前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] strs = new String[Integer.parseInt(num)];
        for (int i = 0; i < Integer.parseInt(num); i++) {
            strs[i] = sc.nextLine();
        }
        while (sc.hasNext()) {
            String s1 = strs[sc.nextInt() - 1];
            String s2 = strs[sc.nextInt() - 1];

            int index = 0;
            int max = 0;

            while (index < s1.length() && index < s2.length()) {
                if (s1.charAt(index) == s2.charAt(index)) {
                    max++;
                    index++;
                } else {
                    break;
                }
            }
            System.out.println(max);
        }
    }
}
