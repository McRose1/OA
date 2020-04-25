package 乐鑫;

/*  无穷素数
    在证明数素无穷性时，使用了一个表达式 N＝2＊3＊5＊7＊11…….＊P + 1，其中 P 为一个素数，N 是 2 到 P 中所有素数的乘积加 1，
    若 P 为最大的素数，可以反证出 N 也是素数，从而证明素数是无穷多的。但有人因此认为，所有的 N 都是素数。
    如N0 = 3 为 素数，N1 = 7 为素数，N2 = 31 为素数。请判断第 i 个 N 是否为素数。

    输入描述：
    每组输入只有一行，包含一个整数i(0 <= i <= 14)，表示要检查的是第i个N。

    输出描述：
    输出只有一行，若Ni为素数，打印“Ni is a prime”，否则打印“Ni is not a prime”。

    输入例子：
    1

    输出例子：
    7 is a prime
 */

import java.util.Scanner;

public class 无穷素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        long[] prime = new long[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

        long temp = 1;
        for (int k = 0; k <= i; k++) {
            temp *= prime[k];
        }
        long N = temp + 1;
        for (int j = 2; j <= N / j; j++) {
            if (N % j == 0) {
                System.out.println(N + " is not a prime");
                return;
            }
        }
        System.out.println(N + " is a prime");
    }
}
