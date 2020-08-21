package 滴滴;

/*  末尾 0 的个数（编程之美 128 页）
    输入一个正整数，求 n!（即阶乘）末尾有多少个 0？比如：n = 10; n! = 3628800，所以答案为 2

    输入描述:
    输入为一行，n(1 ≤ n ≤ 1000)
    输出描述:
    输出一个整数,即题目所求

    示例：
    输入：
    10
    输出：
    2
 */

import java.util.Scanner;

public class 末尾0的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                count++;
                j /= 5;
            }
        }
        System.out.println(count);
    }
}
