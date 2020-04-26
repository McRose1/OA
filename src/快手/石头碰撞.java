package 快手;

/*  石头碰撞（LC 1046 加大难度版）从无脑拿 2 个最重的石头碰撞到需要有策略地碰撞使得最后剩余石头的质量最小
    给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
    1. 如果x==y，碰撞结果为两个石头消失
    2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
    最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。

    输入描述：
    第一行输入石头个数(<=100)
    第二行输入石头质量，以空格分割，石头质量总和<=10000

    输出描述：
    最终的石头质量

    输入例子：
    6
    2 7 4 1 8 1
    输出例子：
    1
 */

import java.util.Scanner;
//  DP (0-1背包问题)：将石头均分为两堆，小堆和大堆，让小堆最大就能保证两个堆差值最小
public class 石头碰撞 {
    public static void main(String[] args) {    // 23 - 11 + 12
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        int sum = 0;
        for (int num : weight) {
            sum += num;
        }
        int average = sum / 2;

        boolean[] status = new boolean[average + 1];
        status[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = average; j >= weight[i]; j--) {
                status[j] = status[j] || status[j - weight[i]];
            }
        }
        int diff = 0;
        for (int i = average; i > 0; i--) {
            if (status[i]) {
                diff = (sum - i) - i;
                break;
            }
        }
        System.out.println(diff);
    }
}
