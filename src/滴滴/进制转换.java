package 滴滴;

/*  进制转换
    给定一个十进制数 M，以及需要转换的进制数 N。将十进制 M 转化为 N 进制数。

    输入描述:
    输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
    输出描述:
    为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）

    示例：
    输入：
    7 2
    输出：
    111
 */

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        char[] arr = new char[] {'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        boolean negative = false;

        if (M < 0) {
            negative = true;
            M = -M;
        }
        while (M != 0) {
            temp = M % N;
            if (temp > 9) {
                sb.append(arr[temp - 9 - 1]);
            } else {
                sb.append(temp);
            }
            M /= N;
        }
        if (negative) {
            sb.append("-");
        }
        System.out.println(sb.reverse().toString());
    }
}
