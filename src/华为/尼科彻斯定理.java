package 华为;

/*  尼科彻斯定理
    验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
    例如：
    1^3=1
    2^3=3+5
    3^3=7+9+11
    4^3=13+15+17+19

    输入描述:
    输入一个int整数 (取值范围：1～100)

    输出描述:
    输出分解后的string

    示例1
    输入
    6
    输出
    31+33+35+37+39+41
 */

import java.util.Scanner;

public class 尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int target = m * m * m;
        int mean = target / m;

        StringBuilder sb = new StringBuilder();
        int offset = -(m - 1);
        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                sb.append(mean + offset);
            } else {
                sb.append(mean + offset);
                sb.append("+");
                offset += 2;
            }
        }
        System.out.println(sb.toString());
    }
}
