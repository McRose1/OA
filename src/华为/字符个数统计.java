package 华为;

/*  字符个数统计
    编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
    输入
    abaca
    输出
    3
    输入描述:
    输入N个字符，字符在ACSII码范围内。

    输出描述:
    输出范围在(0~127)字符的个数。

    示例1
    输入
    abc
    输出
    3
 */

import java.util.Scanner;

public class 字符个数统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        boolean[] used = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 127) {
                if (!used[c]) {
                    count++;
                    used[c] = true;
                }
            }
        }
        System.out.print(count);
    }
}
