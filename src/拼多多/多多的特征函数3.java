package 拼多多;

/*  多多的特征函数3
    若某个正整数 X 可以被特征值集合中的某个数 Y 整除，那么 X 具有显著特征

    给定 N，表示正整数集合 1~N,
    M 表示有 M 个特征值组成的集合

    示例 1：
    输入：
    10 1
    2
    输出：
    5
    说明：
    2，4，6，8，10

    示例 2：
    输入：
    10 2
    2 3
    输出：
    7
    说明：
    2，4，6，8，10
    3，6，9

    示例 3：
    输入：
    10 3
    2
    3
    5
    输出：
    8
 */

import java.util.Arrays;
import java.util.Scanner;

/*  55%

 */
public class 多多的特征函数3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[M];
        for (int i = 0; i < M; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        if (N < nums[0]) {
            System.out.print(0);
            return;
        }
        if (N == nums[0]) {
            System.out.print(1);
            return;
        }

        int count = 0;
        for (int i = nums[0]; i <= N; i++) {
            for (int num : nums) {
                if (i < num) continue;
                if (i % num == 0) {
                    count++;
                    break;
                }
            }
        }
        System.out.print(count);
    }
}
