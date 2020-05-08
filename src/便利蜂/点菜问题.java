package 便利蜂;

/*  点菜问题
    北大网络实验室经常有活动需要叫外卖，但是每次叫外卖的报销经费的总额最大为C元，有N种菜可以点，
    经过长时间的点菜，网络实验室对于每种菜i都有一个量化的评价分数（表示这个菜可口程度），为Vi，每种菜的价格为Pi,
    问如何选择各种菜，使得在报销额度范围内能使点到的菜的总评价分数最大。
    注意：由于需要营养多样化，每种菜只能点一次。

    输入描述：
    输入的第一行有两个整数C（1 <= C <= 1000）和N（1 <= N <= 100），C代表总共能够报销的额度，N代表能点菜的数目。
    接下来的N行每行包括两个在1到100之间（包括1和100）的的整数，分别表示菜的价格和菜的评价分数。

    输出描述：
    输出只包括一行，这一行只包含一个整数，表示在报销额度范围内，所点的菜得到的最大评价分数。

    输入例子：
    90 4
    20 25
    30 20
    40 50
    10 18
    40 2
    25 30
    10 8

    输出例子：
    95
    38
 */

import java.util.Scanner;
//  01 背包问题一维 DP
public class 点菜问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int C = sc.nextInt();
            int N = sc.nextInt();
            int[] price = new int[N];
            int[] rating = new int[N];
            for (int i = 0; i < N; i++) {
                price[i] = sc.nextInt();
                rating[i] = sc.nextInt();
            }
            int[] dp = new int[C + 1];
            for (int i = 0; i < N; i++) {
                // 注意！内层循环是逆序的！
                // 因为 dp[j] 是由 dp[j - price[i]] 推出来的，如果是顺序，比如j从 20-90,那么在算j=40的时候
                // 可能会出现 dp[40] 由 dp[40-20] 推出，而dp[20] 在本轮之前已经被更新过了，就无法记录上一层的信息
                for (int j = C; j >= price[i]; j--) {   // j >= price[i] 确保了可以有两个选择
                    // 点或者不点
                    dp[j] = Math.max(dp[j], dp[j - price[i]] + rating[i]);
                }
            }
            System.out.println(dp[C]);
        }
    }
}
