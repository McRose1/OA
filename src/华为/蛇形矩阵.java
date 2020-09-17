package 华为;

/*  蛇形矩阵
    蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。

    样例输入

    5

    样例输出

    1 3 6 10 15

    2 5 9 14

    4 8 13

    7 12

    11

    输入描述:
    输入正整数N（N不大于100）

    输出描述:
    输出一个N行的蛇形矩阵。

    示例1
    输入
    4
    输出
    1 3 6 10
    2 5 9
    4 8
    7
 */

import java.util.Scanner;

public class 蛇形矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int first_col = 1;
        for (int i = 1; i <= N; i++) {
            System.out.print(first_col);
            int temp = first_col;
            for (int j = i + 1; j <= N; j++) {
                temp += j;
                System.out.print(" " + temp);
            }
            System.out.println();
            first_col += i;
        }
    }
}


/*  my version

        int num = 1;
        int base = 1;
        int rowBase = 0;
        for (int i = 0; i < N; i++) {
            int colBase = 1;
            num += rowBase;
            int offset = colBase + base;
            int temp = num;
            for (int j = 0; j < N - base + 1; j++) {
                if (j == N - base) {
                    System.out.println(num);
                    num = temp;
                } else {
                    System.out.print(num + " ");
                    num += offset;
                    offset++;
                }
            }
            base++;
            rowBase++;
        }
 */