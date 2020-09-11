package 天翼云;

/*  不相邻的最大和
    给定一个整数列表，在列表中挑选任意个数的值，使得挑选出值的和最大，要求挑选的值在原列表中不能相邻。

    输入：
    1,2,3,4,5
    输出：
    9
 */

import java.util.Scanner;

public class 不相邻的最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(",");
        int n = str.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            if (nums[i] > 0) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 1]);
            }
        }
        System.out.println(dp[n - 1]);
    }
}
