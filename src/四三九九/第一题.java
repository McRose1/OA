package 四三九九;

/*
    一球从 100 米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第 n 次落地时，共经过多少米？第 n 次反弹多高？（n<=10）

    输入描述：
    一行，一个整数 n（1<=n<=10）。

    输出描述：
    输出两个浮点数 ans1, ans2。ans1 为第 n 次落地时，共经过的距离；ans2 为第 n 次反弹的高度。答案应与标准答案误差小于 1e-5。两个数间以空格相间。

    输入例子 1：
    1
    输出例子 1：
    100.000000 50.000000

    输入例子 2：
    10
    输出例子 2：
    299.609375 0.097656
 */

import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        float height = 50.0f;
        float sum = 100.0f;

        for (int i = 1; i < n; i++) {
            sum += height * 2;
            height /= 2;
        }

        System.out.println(sum + " " + height);
    }
}
