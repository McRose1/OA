package 字节跳动;

/*  足球赛
    有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。
    现在已经踢完了k场比赛，每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。
    已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。
    求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。

    输入描述：
    第一行包含一个数字 t (1 <= t <= 10)
    接下来的t行每行包括四个数字 n, k, d1, d2(1 <= n <= 10^12; 0 <= k <= n, 0 <= d1, d2 <= k)

    输出描述：
    每行的比分数据，最终三只球队若能够打平，则输出“yes”，否则输出“no”

    输入例子：
    2
    3 3 0 0
    3 3 3 3

    输出例子：
    yes
    no

    例子说明：
    case1: 球队1和球队2差0分，球队2和球队3也差0分，所以可能的比赛得分是三只球队各得1分
    case2: 球队1和球队2差3分，球队2和球队3差3分，所以可能的得分是 球队1得0分，球队2得3分, 球队3得0分，比赛已经全部结束因此最终不能打平。
 */

import java.util.Scanner;

public class 足球赛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            if (n - k == 0) {
                if (d1 == 0 && d2 == 0) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                int remain = n - k;
                if (remain >= d1 + d2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
