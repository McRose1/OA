package 深信服;

/*  围棋遍历
    函数calc计算围棋中位置(x,y)处连成一片的棋子个数。
    所谓连成一片，即沿着棋盘横竖线往任意方向遍历，遍历过程允许转弯，不允许走斜线，中间未出现对方棋子或空子。

    输入描述:
    第1-19行数据是棋盘上棋子的颜色数据。
    0表示未落子，1表示白子，2表示黑子。
    第1行最左边位置的坐标是(0,0)，第1行第2列的坐标是(1,0)，第2行第1列的坐标是(0,1)，依此类推。
    第20行数据是起始坐标(x,y)

    输出描述:
    与坐标(X,Y)连成一片的棋子数目

    输入例子1:
    0000000000000000000
    0000011000000000000
    0000001111000000000
    0000001021000000000
    0000001010100000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    0000000000000000000
    5,1

    输出例子1:
    9
 */

import java.util.Scanner;

public class 围棋遍历 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 19; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        String s = sc.nextLine();
        String[] str = s.split(",");
        int col = Integer.parseInt(str[0]);
        int row = Integer.parseInt(str[1]);

        int[] count = new int[] {0};
        dfs(board, row, col, count, 1);
        int max = count[0];
        count[0] = 0;
        dfs(board, row, col, count, 2);
        max = Math.max(max, count[0]);
        System.out.println(max);
    }

    private static void dfs(int[][] board, int x, int y, int[] count, int color) {
        if (x < 0 || x >= 19 || y < 0 || y >= 19 || board[x][y] == 0 || board[x][y] != color) {
            return;
        }

        board[x][y] = 0;
        count[0]++;
        dfs(board, x + 1, y, count, color);
        dfs(board, x - 1, y, count, color);
        dfs(board, x, y + 1, count, color);
        dfs(board, x, y - 1, count, color);
    }
}
