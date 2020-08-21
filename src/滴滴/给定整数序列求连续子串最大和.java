package 滴滴;

/*  给定整数序列求连续子串最大和
    给定无序整数序列，求连续非空子串最大和，例如 {-23 17 -7 11 -2 1 -34}，子串为 {17, -7, 11}，最大和为 21

    输入描述:
    输入为整数序列，数字用空格分隔，如：-23 17 -7 11 -2 1 -34
    输出描述:
    输出为子序列的最大和：21

    示例：
    输入：
    -23 17 -7 11 -2 1 -34
    输出：
    21
 */

import java.util.Scanner;

public class 给定整数序列求连续子串最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int res : dp) {
            max = Math.max(max, res);
        }
        System.out.println(max);
    }
}
