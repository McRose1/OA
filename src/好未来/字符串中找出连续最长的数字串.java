package 好未来;

/*  字符串中找出连续最长的数字串
    读入一个字符串str，输出字符串str中的连续最长的数字串

    输入描述:
    个测试输入包含1个测试用例，一个字符串str，长度不超过255。

    输出描述:
    在一行内输出str中里连续最长的数字串。

    输入例子1:
    abcd12345ed125ss123456789

    输出例子1:
    123456789
 */

import java.util.Scanner;

public class 字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            }
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.length() > res.length()) {
                res = sb.toString();
            }
            sb = new StringBuilder();
            i--;
        }
        System.out.println(res);
    }
}
