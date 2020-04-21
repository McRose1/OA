package 四三九九;

/*  LC 70
    段誉身具凌波微波，动无常则，若危若安，一次能走一级台阶或者两级台阶，他要爬一段30级的山路，问有多少种走法？分析如何计算，然后编程解答。
    进阶问题：当他轻功熟练度提升，一次最多可以走三级，那就结果有什么变化？后来走火入魔了，不能走一级，只能走二或三级，又有什么变化？

    输入描述：
    输入一个数n（1<=n<=30），代表段誉要爬一段n级的山路。

    输出描述：
    输出三个整数a,b,c（以空格相间）。其中a为段誉一次能走一级或两级台阶的走法；b为段誉一次能走一级、二级或三级台阶的走法；c为段誉一次能走二级或三级台阶的走法。

    输入例子：
    3

    输出例子：
    3 4 1
 */

import java.util.Scanner;

public class 爬楼梯问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("1 1 0");
            return;
        }

        if (n == 2) {
            System.out.println("2 2 1");
            return;
        }

        int[] dp1 = new int[n];
        dp1[0] = 1;
        dp1[1] = 2;

        for (int i = 2; i < n; i++) {
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }
        int res1 = dp1[n - 1];

        int[] dp2 = new int[n];
        dp2[0] = 1;
        dp2[1] = 2;
        dp2[2] = 4;

        for (int i = 3; i < n; i++) {
            dp2[i] = dp2[i - 1] + dp2[i - 2] + dp2[i - 3];
        }
        int res2 = dp2[n - 1];

        int[] dp3 = new int[n];
        dp3[0] = 0;
        dp3[1] = 1;
        dp3[2] = 1;

        for (int i = 3; i < n; i++) {
            dp3[i] = dp3[i - 2] + dp3[i - 3];
        }
        int res3 = dp3[n - 1];

        System.out.println(res1 + " " + res2 + " " + res3);
    }
}
