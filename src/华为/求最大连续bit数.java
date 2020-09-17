package 华为;

/*  求最大连续bit数
    功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1

    输入: 一个byte型的数字

    输出: 无

    返回: 对应的二进制数字中1的最大连续数
    输入描述:
    输入一个byte数字

    输出描述:
    输出转成二进制之后连续1的个数

    示例1
    输入
    3
    输出
    2
 */

import java.util.Scanner;

public class 求最大连续bit数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String binary = Integer.toBinaryString(num);
        int count = 0;
        int max = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }
}
