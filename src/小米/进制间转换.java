package 小米;

/*  进制间转换
    设计一个函数， 可以将任意十进制的数， 转换成任意2到9的进制表示的形式

    输入描述:
    需要转换的数字x(0<=x<=1e18) 转换使用的进制k(2<=k<=9)
    输出描述:
    对应进制的结果

    示例1
    输入
    33 2
    输出
    100001
 */

import java.util.Scanner;

public class 进制间转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int k = sc.nextInt();
        System.out.print(radix(x, k));
    }

    private static String radix(long x, int k) {
        StringBuilder sb = new StringBuilder();
        if (x == 0) {
            return "0";
        }
        while (x != 0) {
            sb.append(x % k);
            x /= k;
        }
        return sb.reverse().toString();
    }
}
