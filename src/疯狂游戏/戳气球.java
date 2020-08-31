package 疯狂游戏;

/*  戳气球 (LC 312)
    Input: [3,1,5,8]
    Output: 167
 */

import java.util.Scanner;

public class 戳气球 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] in = input.split(",");
        int n = in.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }
        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = arr[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        // 从最小的子问题开始算：[1,3,1] [3,1,5] [1,5,8] [5,8,1] -> [1,3,1,5] [3,1,5,8] [1,5,8,1] ...
        for (int len = 2; len < n + 2; len++) {
            // 左边界
            for (int i = 0; i < n + 2 - len; i++) {
                // 右边界
                int j = i + len;
                // 在这个边界内遍历每一种可能（就是戳气球的过程）
                for (int k = i + 1; k < j; k++) {
                    int sum = arr[i] * arr[k] * arr[j];
                    sum += (dp[i][k] + dp[k][j]);
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        System.out.print(dp[0][n + 1]);
    }
}
