package 字节跳动;

/*  机器人跳跃问题
    机器人正在玩一个古老的基于DOS的游戏。游戏中有N+1座建筑——从0到N编号，从左到右排列。编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位。
    起初， 机器人在编号为0的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E, 下一步它将跳到第个k+1建筑。
    它将会得到或者失去正比于与H(k+1)与E之差的能量。如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。
    游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？

    数据约束：
    1 <= N <= 10^5
    1 <= H(i) <= 10^5

    输入描述：
    第一行输入，表示一共有 N 组数据.
    第二个是 N 个空格分隔的整数，H1, H2, H3, ..., Hn 代表建筑物的高度

    输出描述：
    输出一个单独的数表示完成游戏所需的最少单位的初始能量

    输入例子 1：
    5
    3 4 3 2 4
    输出例子 1：
    4

    输入例子 2：
    3
    4 4 4
    输出例子 2：
    4

    输入例子 3：
    3
    1 6 4
    输出例子 3：
    3
 */

import java.util.Scanner;
/*  DP
    假设跳跃前能力为E,要跳的高度为H，那么跳跃后的能量就是2E-H
    因为如果H(k+1) > E(k),那么 E(k+1) = E - (H - E) = 2E(k) - H(k+1)，
    否则 E = E + (E - H) = 2E - H
    那么跳跃后的能量加上高度就是跳跃前的两倍，然后从后往前逆推: E(k) = (E(k+1) + H(k+1)) / 2
    每次只关心 N-1 -> N、N-2 -> N-1... 最低需要多少能量可以达到下一步
 */
public class 机器人跳跃问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = sc.nextInt();
        }
        int[] dp = new int[N + 1];
        for (int i = N; i > 0; i--) {
            // 如果被除数为奇数，E 肯定得往大了取，所以让其加 1 变成偶数，如果是偶数，加 1 也不会影响
            dp[i - 1] = (dp[i] + height[i] + 1) / 2;
        }
        System.out.println(dp[0]);
    }
}
