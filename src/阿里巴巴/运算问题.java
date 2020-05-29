package 阿里巴巴;

/*
    数组里有 n 个元素，从中选择 3 个数 a, b, c 使得 (a+b)^c 最大

    输入：
    2
    3
    1 2 3
    3
    100 200 300

    输出：
    6
    400
 */

import java.util.Scanner;

public class 运算问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (a[0] + a[1] == a[2]) {
                System.out.println((a[0] + a[2]) ^ a[1]);
            }
        }
    }
}
