package 华为;

/*  字符串最后一个单词的长度
    计算字符串最后一个单词的长度，单词以空格隔开。

    输入描述:
    一行字符串，非空，长度小于5000。

    输出描述:
    整数N，最后一个单词的长度。

    示例1
    输入
    hello world
    输出
    5

 */

import java.util.Scanner;

public class 字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split(" ");
        int len = str[str.length - 1].length();
        System.out.print(len);
    }
}
