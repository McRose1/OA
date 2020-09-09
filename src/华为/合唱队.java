package 华为;

/*  合唱队
    计算最少出列多少位同学，使得剩下的同学排成合唱队形

    说明：

    N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
    合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
    则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。

    你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。

    注意不允许改变队列元素的先后顺序
    请注意处理多组输入输出！

    输入描述:
    整数N

    输出描述:
    最少需要几位同学出列

    示例1
    输入
    8
    186 186 150 200 160 130 197 200
    输出
    4
 */

import java.util.Scanner;

/*  2 个 DP 数组（和 LC 123 类似）
    递增 LIS，逆向递增 LIS
    186 186 150 200 160 130 197 200
     1   1   1   2   2   1   3   4
     3   3   1   3   2   1   1   1
     4   4   2   5   4   2   4   5
 */
public class 合唱队 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] student = new int[N];
        for (int i = 0; i < N; i++) {
            student[i] = sc.nextInt();
        }

        int[] inc = new int[N];
        inc[0] = 1;
        for (int i = 1; i < N; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (student[j] < student[i] && inc[j] + 1 > inc[i]) {
                    inc[i] = inc[j] + 1;
                }
            }
        }

        int[] dec = new int[N];
        dec[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            dec[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (student[j] < student[i] && dec[j] + 1 > dec[i]) {
                    dec[i] = dec[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, inc[i] + dec[i]);
        }
        System.out.println(N - (max - 1));
    }
}
