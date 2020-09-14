package 华为;

/*  查找输入整数二进制中1的个数
    注意多组输入输出！！！！！！

    输入描述:
    输入一个整数

    输出描述:
    计算整数二进制中1的个数

    示例1
    输入
    5
    输出
    2
 */

import java.util.Scanner;

public class 查找输入整数二进制中1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
