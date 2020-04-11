package 美团;

/*  代金券组合（类似 LC 322 Coin Change）
    近期某商场由于周年庆，开启了“0 元购”活动。活动中，消费者可以通过组合手中的代金券，实现 0 元购买指定商品。
    聪明的小团想要用算法来帮助他快速计算：对于指定价格的商品，使用代金券凑出其价格即可，但所使用的代金券总面额不可超过商品价格。
    由于代金券数量有限，使用较少的代金券张数可以实现价值最大化，即最佳优惠。
    假设现有 100 元的商品，而代金券有 50 元、30元、20元、5 元四种，则最佳优惠是两张 50 面额的代金券；
    而如果现有 65 元的商品，则最佳优惠是两张 30 元代金券以及一张 5 元代金券。
    请你帮助小团使用一段代码来实现代金券计算。

    输入描述：
    多组输入输出，读到 s=0 时结束
    输入可以有多个测试样例，每个测试由两行组成。
    其中第一行包含一个整数 P，表示商品的价格，1<=P<=10000；输入 P 为 0 时表示结束。
    第二行包含若干整数，使用空格分割。其中第一个整数 N(1<=N<=20) 表示有多少种代金券，其后跟随 M 个整数，表示手中持有的代金券面额（1<=N<=1000），每种代金券数量不限。

    输出描述：
    找出最少张数的代金券，使其面额恰好等于商品的价格。输出所使用的代金券数量：
    如果有多个最优解，只输出其中一种即可；
    如果无解，则需输出“Impossible”。

    输入例子：
    65
    4 50 30 20 5

    输出例子：
    3
 */

import java.util.Arrays;
import java.util.Scanner;

//  一维 DP
public class 代金券组合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount == 0) {
                break;
            } else {
                int len = sc.nextInt();
                int[] nums = new int[len];
                for (int i = 0; i < len; i++) {
                    nums[i] = sc.nextInt();
                }

                int[] dp = new int[amount + 1];
                Arrays.fill(dp, amount + 1);
                dp[0] = 0;

                for (int i = 1; i <= amount; i++) {
                    for (int j : nums) {
                        if (j <= i) {
                            dp[i] = Math.min(dp[i], dp[i - j] + 1);
                        }
                    }
                }
                if (dp[amount] > amount) {
                    System.out.println("Impossible");
                } else {
                    System.out.println(dp[amount]);
                }
            }
        }
    }
}
