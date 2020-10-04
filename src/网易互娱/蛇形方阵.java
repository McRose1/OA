package 网易互娱;

/*  蛇形方阵
    给定 N，我们给出多个需要查询的坐标（x, y），请输出 N 维蛇形方阵中（x, y）的值是多少。

    输入描述：
    输入第一行为一个正整数 C，表示有 C 组数据；
    每组数据的第一行位正整数 N，M，表示蛇形方阵维度 N 和 M 个查询；
    紧接着 M 行每行包含两个非负整数，表示查询的坐标。

    输入：
    1
    7 3
    0 2
    2 0
    4 4

    输出：
    3
    23
    45
 */

import java.util.Scanner;

public class 蛇形方阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while (C-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] pos = new int[M][2];
            for (int i = 0; i < M; i++) {
                pos[i][0] = sc.nextInt();
                pos[i][1] = sc.nextInt();
            }
            int[][] matrix = new int[N][N];
            int n = 1;
            int layer = 0;
            while (n <= N * N) {
                if (layer % 2 == 0) {
                    for (int j = layer; j < N - layer; j++) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[layer][j] = n;
                        n++;
                    }
                    for (int i = layer + 1; i < N - layer; i++) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[i][N - layer - 1] = n;
                        n++;
                    }
                    for (int j = N - layer - 2; j >= layer; j--) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[N - layer - 1][j] = n;
                        n++;
                    }
                    for (int i = N - layer - 2; i > layer; i--) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[i][layer] = n;
                        n++;
                    }
                    layer++;
                } else {
                    for (int i = layer; i < N - layer; i++) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[i][layer] = n;
                        n++;
                    }
                    for (int j = layer + 1; j < N - layer; j++) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[N - layer - 1][j] = n;
                        n++;
                    }
                    for (int i = N - layer - 2; i >= layer; i--) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[i][N - layer - 1] = n;
                        n++;
                    }
                    for (int j = N - layer - 2; j > layer; j--) {
                        if (n > N * N) {
                            break;
                        }
                        matrix[layer][j] = n;
                        n++;
                    }
                    layer++;
                }
            }
            for (int[] p : pos) {
                System.out.println(matrix[p[0]][p[1]]);
            }
        }
    }
}
