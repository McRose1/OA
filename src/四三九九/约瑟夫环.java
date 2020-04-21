package 四三九九;

/*  力扣面试题 62
    有 n 个人围成一圈，顺序排号。从第一个人开始报数（从 1 到 3 报数），凡报到 3 的人退出圈子，问最后留下的是原来第几号的那位。

    输入描述：
    一行，一个正整数 n（1<=n<=1000000）。

    输出描述：
    输出答案。

    输入例子：
    5

    输出例子：
    4

    例子说明：
    出局的编号依次为3,1,5,2，最后留下的是4
 */

import java.util.Scanner;

public class 约瑟夫环 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + 3) % i;
        }
        System.out.println(res + 1);
    }
}
