package 招商银行;

/*  LC 765
    在一场集体婚礼上，有n对新人需要坐在连续排列的 2n 个座位上合影，同一对新人彼此挨着。
    由于进场时各对新人并未按序入座，请计算最少交换座位的次数，以便使每对新人均可并肩坐在一起。
    一次交换可选择任意两人，让他们互换座位。
    全部新人的序号可用 0 到 2n-1 的整数表示，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2n-2, 2n-1)。
    row[i]指最初坐在第 i 个座位上的新人编号，i是从0到（2n-1）的一个升序全排列，row不存在重复值。

    输入描述:
    输入共有2行，第一行为n，即共有多少对新人(2 ≤ n ≤ 100000)，第二行为row，即2n个座位上的初始新人编号。
    输出描述:
    输出最少交换座位的次数。

    示例1
    输入
    2
    0 2 1 3
    输出
    1
    说明
    我们只需要交换1和2的位置即可

    示例2
    输入
    2
    3 2 0 1
    输出
    0
    说明
    无需交换座位，所有的新人都已经并肩坐在一起
 */

import java.util.Scanner;

public class 交换座位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i += 2) {
            if (Math.abs(nums[i] - nums[i + 1]) == 1) {
                count++;
            }
        }
        if (count == n) {
            System.out.println(0);
            return;
        }
        return;
    }
}
