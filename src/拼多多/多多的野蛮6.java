package 拼多多;

/*  多多的野蛮6

    多多现在有一个道具可以移动任意一个格子上的士兵到任意一个空格子

    示例 1：
    输入：
    4 4
    1 0 1 1
    1 1 0 1
    0 0 0 0
    1 1 1 1
    输出：
    8
    说明：
    1 0 1 1
    1 1 0 0
    1 0 0 0
    1 1 1 1

    示例 2：
    输入：
    3 4
    0 1 0 0
    1 0 1 1
    0 1 0 0
    输出：
    5
    说明：
    0 1 0 0
    0 1 1 1
    0 1 0 0
 */

import java.util.Scanner;

/*  15%

 */
public class 多多的野蛮6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int[] count = new int[] {0};
                    boolean[] chance = new boolean[] {false};
                    dfs(matrix, i, j, chance, count);
                    max = Math.max(max, count[0]);
                }
            }
        }
        System.out.print(max);
    }

    private static int row;
    private static int col;

    private static void dfs(int[][] matrix, int i, int j, boolean[] chance, int[] count) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (matrix[i][j] == 0 && chance[0]) {
            return;
        }

        matrix[i][j] = 0;
        count[0]++;
        if (matrix[i][j] == 0) {
            chance[0] = true;
        }
        dfs(matrix, i + 1, j, chance, count);
        dfs(matrix, i - 1, j, chance, count);
        dfs(matrix, i, j + 1, chance, count);
        dfs(matrix, i, j - 1, chance, count);
    }
}
