package 便利蜂;

/*
    便利蜂便利店有一排货架，长度已知为length，上面可以来摆放商品。现在你有很多商品可以选择是否摆到货架上，希望获得最大销售额。
    其中每个商品，如果把它摆到货架上，它会占用w的宽度，预计销售额为v。
    约束：
    1)      1个商品只能摆放一次；
    2)      所有摆放商品的总宽度不能超过货架的长度L；
    请计算出最大销售额。

    输入
    public int layout(int length, int[] widths, int[] values)

    输出
    返回：最大销售额

    样例输入
    10
    1,2,3,4,5,6,7
    10,9,8,7,6,5,4
    样例输出
    34

    提示
    length: 该货架长度
    widths: 每个商品的宽度数组
    values: 每个商品的预计销售额
 */

import java.util.*;
//  01 背包问题二维 DP
public class 宽度背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());

        String[] w = sc.nextLine().split(",");
        String[] v = sc.nextLine().split(",");

        int[] width = new int[w.length];
        for (int i = 0; i < width.length; i++) {
            width[i] = Integer.parseInt(w[i]);
        }

        int[] value = new int[v.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Integer.parseInt(v[i]);
        }

        int count = width.length;

        int[][] dp = new int[count + 1][length + 1];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= length; j++) {
                if (j < width[i - 1]) {
                    // 该货物的宽度已经超过货架长度，肯定不能选
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 可以选也可以不选
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - width[i - 1]] + value[i - 1]);
                }
            }
        }
        System.out.println(dp[count][length]);
    }
}
