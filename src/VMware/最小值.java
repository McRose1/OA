package VMware;

/*  最小值
    给你一个长度为n的数组A和一个长度为m的数组B，以及一个模数mod，
    你需要从数组A里选取一个数x，从数组B中选取一个数y，使得(x+y)%mod的值是所有选取方式中最小的，输出这个最小值即可。

    输入描述
    第一行三个整数n，m，mod，分别表示A数组的长度、B数组的长度以及模数。
    第二行n个整数，第i个数表示A数组中第i个数的大小。
    第三行m个整数，第i个数表示B数组中第i个数的大小。
    数字间均以空格隔开。

    1 <= n, m <= 100000
    1 <= A[i], B[i], mod <= 10^18

    输出描述
    一个整数x，表示求得的最小值。

    样例输入
    4 5 10
    2 3 4 5
    1 2 3 4 6
    样例输出
    0

    提示
    样例输入2
    2 2 100000000007
    27234626274 344569274255
    9237235275 23974652789327

    样例输出2
    1887413921
 */

import java.util.Scanner;

/*  73%

 */
public class 最小值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long mod = sc.nextLong();
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }
        long[] B = new long[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextLong();
        }
        long min = Long.MAX_VALUE;
        for (long a : A) {
            for (long b : B) {
                min = Math.min(min, (a + b) % mod);
                if (min == 0) {
                    break;
                }
            }
        }
        System.out.println(min);
    }
}
