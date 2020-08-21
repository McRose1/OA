package 滴滴;

/*  连续最大和
    一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
    输入描述:
    输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
    输出描述:
    所有连续子数组中和最大的值。

    示例：
    输入
    3 -1 2 1
    输出
    3
 */

import java.util.Scanner;

/*  DP

 */
public class 连续最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int res : dp) {
            max = Math.max(max, res);
        }
        System.out.println(max);
    }
}
