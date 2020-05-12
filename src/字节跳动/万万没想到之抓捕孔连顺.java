package 字节跳动;

/*  万万没想到之抓捕孔连顺
    和我一起行动的还有另外两名特工，我提议：
    1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
    2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。

    请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
    注意：
    1. 两个特工不能埋伏在同一地点
    2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用

    输入描述：
    第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
    第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）

    输出描述：
    一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模

    输入例子 1：
    4 3
    1 2 3 4
    输出例子 2：
    4
    例子说明 1：
    可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)

    输入例子 2：
    5 19
    1 10 20 30 50
    输出例子 2：
    1
    例子说明 2：
    可选方案 (1, 10, 20)
 */

import java.util.Scanner;
/*  Sliding Window
    滑动窗口，先移动右边，当不满足的时候再移动左边
 */
public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = sc.nextInt();
        }
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        long count = 0;
        // 用双指针维护滑动窗口的首尾
        int left = 0;
        int right = 2;
        while (right < N) {
            // 窗口大小超过 D，将窗口首部的指针右移一位
            if (buildings[right] - buildings[left] > D) {
                left++;
            } else if (right - left < 2) {
                // 窗口缩小到不能容纳 3 个特工，应该扩大窗口
                right++;
            } else {
                // 窗口满足条件，在该窗口内计算所有可能性的个数
                long n = right - left;
                // 相当于是固定末尾，计算末尾之前的位置放 2 个特工的所有可能性，所以是C(n2)
                count += n * (n - 1) / 2;
                right++;
            }
        }
        count %= 99997867;
        System.out.println(count);
    }
}
