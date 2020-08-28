package 浪潮;

/*  石头
    沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，且不存在两个石头有相同的半径。
    为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
    因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
    问最少需要操作多少次才能将这n个石头的半径变成升序？

    输入描述
    第一行一个整数n，表示石头的个数。
    (1 <= n <= 100000) 第二行n个整数，表示从左往右石头的半径r1，r2，...，rn。(1 <= ri <= n)，且保证不存在两个不同的石头拥有相同的半径。

    输出描述
    最少操作次数

    样例输入
    5
    4 1 2 5 3

    样例输出
    2
 */

import java.util.Scanner;

public class 石头 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.print(0);
            return;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (r[i] > r[i - 1]) {
                count++;
                if (i == n - 1) {
                    max = Math.max(max, count);
                }
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        System.out.print(n - max);
    }
}
