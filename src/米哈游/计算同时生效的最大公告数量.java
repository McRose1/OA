package 米哈游;

/*
    基于当前配置，最多同时有多少个公告可以被玩家看到？

    第一行的整数表示公告配置的数量

    后面每一行有两个用空格分开的整数，表示一条公告的开始、结束时间戳（保证在 32 位整型的取值范围内，并且开始时间 < 结束时间），区间为左闭、右开、

    实例 1：
    输入：
    2
    1 10
    5 15
    输出：
    2

    实例 2：
    输入：
    2
    1 5
    5 10
    输出：
    1
 */

import java.util.Scanner;

public class 计算同时生效的最大公告数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                time[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            int start = time[i][0];
            int end = time[i][1];
            for (int j = i + 1; j < n; j++) {
                if (end > time[j][0]) {
                    count++;
                    end = time[j][1];
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
