package 疯狂游戏;

/*  岛屿数量

 */

import java.util.Scanner;

public class 岛屿数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] in = input.split(",");
        int row = in.length;
        int col = in[0].length();
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            String cur = in[i];
            for (int j = 0; j < col; j++) {
                matrix[i][j] = cur.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    dfs(matrix, i, j);
                }
            }
        }
        System.out.print(count);
    }

    private static void dfs(char[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '0') {
            return;
        }

        matrix[i][j] = '0';
        dfs(matrix, i - 1, j);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
    }
}
