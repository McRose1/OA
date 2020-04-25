package 乐鑫;

/*  求连通域（LC 200 变形）
    连通区域（Connected Component）一般是指图像中具有相同像素值且位置相邻的像素点组成的图像区域。
    每个像素点有8个邻接点，包括了上下左右和对角线的像素点。如果点a与b邻接，称之为a与b连通。如果域A与B连通，B与C连通，则A与C也连通。
    试找出一个二值矩阵的所有连通域（8邻接），并给出每个连通域的面积（邻接点的个数）和重心。

    输入描述：
    每组输入包括 M+1 行，第一行输入2个整数 M (1<M<100), N (1<N<100)，其中M是矩阵的行数，N是矩阵的列数。
    第2至M+1行，每行 N 个整数，表示在矩阵N列的像素值（已二值化为 0 和 1， 连通域为 1 表示的区域）。

    输出描述：
    输出 K+1 行，第一行输出连通域个数K，第2至 K+1 行，每行输出3个数，依次表示为连通域的面积值和重心的坐标值（保留2位小数点），按照连通域起始点顺序输出。

    输入例子：
    4 4
    0 1 0 0
    0 0 0 1
    0 0 0 1
    1 0 0 0

    输出例子：
    3
    1 1.00 0.00
    2 3.00 1.50
    1 0.00 3.00
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 求连通域 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int area = 0;
        List<List<Double>> res = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    area++;
                    int[] info = new int[3];
                    dfs(grid, info, i, j);
                    int count = info[0];
                    int x_sum = info[2];
                    int y_sum = info[1];
                    double x = (double) x_sum / count;
                    double y = (double) y_sum / count;
                    res.add(new ArrayList<>(Arrays.asList((double)count, x, y)));
                }
            }
        }
        System.out.println(area);
        for (int i = 0; i < area; i++) {
            int num = res.get(i).get(0).intValue();
            System.out.print(num + " " + String.format("%.2f", res.get(i).get(1)) + " " + String.format("%.2f", res.get(i).get(2)));
            System.out.println();
        }
    }

    private static void dfs(int[][] grid, int[] info, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        } else {
            info[0]++;
            info[1] += i;
            info[2] += j;
        }

        grid[i][j] = 0;

        dfs(grid, info, i - 1, j - 1);
        dfs(grid, info, i - 1, j);
        dfs(grid, info, i - 1, j + 1);
        dfs(grid, info, i, j - 1);
        dfs(grid, info, i, j + 1);
        dfs(grid, info, i + 1, j - 1);
        dfs(grid, info, i + 1, j);
        dfs(grid, info, i + 1, j + 1);
    }
}
