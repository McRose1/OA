package 拼多多;

/*  最大乘积
    给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)

    输入描述：
    第一行是数组大小n，第二行是无序整数数组A[n]

    输出描述：
    满足条件的最大乘积

    输入例子：
    4
    3 4 1 2

    输出例子：
    24
 */

import java.util.Scanner;
/*
    3 个数最大的乘积有两种可能：
    1. 3 个最大的正数相乘；
    2. 1 个最大的正数和 2 个最小的负数相乘
 */
public class 最大乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        long max3 = Integer.MIN_VALUE;
        long min1 = Integer.MAX_VALUE;
        long min2 = Integer.MAX_VALUE;

        for (int num : A) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        long max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        System.out.println(max);
    }
}
