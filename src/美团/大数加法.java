package 美团;

/*  大数加法
    以字符串的形式读入两个数字，再以字符串的形式输出两个数字的和。

    输入描述：
    输入两行，表示两个数字 a 和 b，-10^9 <= a，b <= 10^9，用双引号括起。

    输出描述：
    输出 a+b 的值，用双括号括起。

    输入例子：
    "-26"
    "100"

    输出例子：
    "74"
 */

import java.util.Scanner;

public class 大数加法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        String num1 = s1.substring(1, s1.length() - 1);
        String num2 = s2.substring(1, s2.length() - 1);

        int res = Integer.parseInt(num1) + Integer.parseInt(num2);
        System.out.print("\"" + res + "\"");
    }
}
