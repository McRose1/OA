package 华为;

/*  求小球落地5次后所经历的路程和最后一次反弹的高度
    假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？

    最后的误差判断是小数点6位

    输入描述:
    输入起始高度，int型

    输出描述:
    分别输出第5次落地时，共经过多少米; 第5次反弹多高

    示例1
    输入
    1
    输出
    2.875
    0.03125
 */

import java.util.Scanner;

public class 求小球落地5次后所经历的路程和最后一次反弹的高度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float height = sc.nextFloat();
        float sum = height;
        height /= 2;
        float five = 0;
        for (int i = 0; i < 4; i++) {
            sum += height * 2;
            height /= 2;
            if (i == 3) {
                five = height;
            }
        }
        System.out.printf("%.6f", sum);
        System.out.println();
        System.out.printf("%.6f", five);
        System.out.println();
    }
}
