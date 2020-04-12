package 美团;

/*  工作安排
    为团队制定工作的计划，以帮助团队产出最大的价值。
    每周团队都会有两项候选的任务，其中一项为简单任务，一项为复杂任务，两项任务都能在一周内完成。
    第 i 周，团队完成简单任务的价值为 li，完成复杂任务的价值为 hi。
    由于复杂任务本身的技术难度较高，团队如果在第 i 周选择执行复杂任务的话，需要在 i-1 周不做任何任务专心准备。（除了第一周）
    如果团队在第 i 周选择执行简单任务的话，不需要提前做任何准备。
    现在收到了未来 N 周的候选任务列表，请确定每周的工作安排使得团队的工作价值最大。

    输入描述：
    第一行为 N（0<=N<=1000）
    接下来的 N 行表示第 1 到 N 周两项候选任务的价值，第 i 行的格式为：li hi，其中 0<li<10000, 0<hi<10000。

    输出描述：
    输出一个数字，表示团队在未来 N 周能产出的最大价值。

    输入例子：
    4
    10 5
    1 50
    10 5
    10 1

    输出例子：
    70
 */

import java.util.Scanner;
//  DP
public class 工作安排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int week = Integer.parseInt(sc.nextLine());
        if (week == 0) return;
        int[] easy = new int[week];
        int[] hard = new int[week];
        for (int i = 0; i < week; i++) {
            String[] value = sc.nextLine().split(" ");
            easy[i] = Integer.parseInt(value[0]);
            hard[i] = Integer.parseInt(value[1]);
        }

        if (week == 1) {
            System.out.println(Math.max(easy[0], hard[0]));
            return;
        }

        int[] dp = new int[week];
        dp[0] = Math.max(easy[0], hard[0]);
        dp[1] = Math.max(dp[0] + easy[1], hard[1]);
        for (int i = 2; i < week; i++) {
            int easyValue = dp[i - 1] + easy[i];
            int hardValue = dp[i - 2] + hard[i];
            dp[i] = Math.max(easyValue, hardValue);
        }
        int res = dp[week - 1];
        System.out.println(res);
    }
}
