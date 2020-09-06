package 华为;

/*  计算字符个数

    写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

    输入描述:
    第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。

    输出描述:
    输出输入字符串中含有该字符的个数。

    示例1
    输入
    ABCDEF
    A
    输出
    1
 */

import java.util.Scanner;

public class 计算字符个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String target = sc.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            char tar = target.charAt(0);
            if (Character.toLowerCase(cur) == Character.toLowerCase(tar)) {
                count++;
            }
        }
        System.out.print(count);
    }
}
