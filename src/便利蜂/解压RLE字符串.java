package 便利蜂;

/*
    给你一个以RLE压缩的字符串，请你返回解压后的字符串。

    输入
    输入的字符串中，每对相邻的两个字符 ab，其中a为 1~9的数字，b为任意字符。
    1)      字符串长度大于等于 2 小于等于 100；
    2)      字符串长度是 2 的整数倍。

    输出
    解压ab 的结果为： bbb...b (一共a个值b的元素)。

    样例输入
    1a2b
    样例输出
    abb
 */

import java.util.Scanner;

public class 解压RLE字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            int count = s.charAt(i) - '0';
            while (count-- > 0) {
                sb.append(s.charAt(i + 1));
            }
        }
        System.out.println(sb.toString());
    }
}
