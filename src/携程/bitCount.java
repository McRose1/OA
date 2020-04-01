package 携程;

/*  bit count
    输入一个 long 类型的数值，求该数值的二进制表示中的 1 的个数。

    输入例子 1：
    3

    输出例子 1：
    2

    输入例子 2：
    65

    输出例子 2：
    2
 */

import java.util.Scanner;
/*  Bit Manipulation
    注意，这题虽然看着很像 (LC 338)，但是！这里要求的是 long，如果用 dp[] 数组做会越界
 */
public class bitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int count = 0;
        while (num != 0) {
            // num & (num - 1) 每次消去 num 最右边的 1
            num = num & (num - 1);
            count++;
        }
        System.out.println(count);
    }
}
