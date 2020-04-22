package 美团;

/*  棋子翻转
    在4*4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，
    要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。

    输入描述：
    给定两个数组，分两行
    第一行分别为初始棋盘，为 4*4 矩阵，其中 0 表示白色棋子，1 表示黑色棋子
    第二行为翻转位置，其中翻转位置共有 3 个

    输出描述：
    请返回翻转后的棋盘，为4*4矩阵

    输入例子：
    [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]]
    [[2,2],[3,3],[4,4]]

    输出例子：
    [[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
 */

import java.util.Scanner;

public class 棋子翻转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("[^01]", "");
        int[][] matrix = new int[4][4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = Integer.parseInt(str.substring(index, index + 1));
                index++;
            }
        }
        String flip = sc.nextLine().replaceAll("[^1-4]", "");
        int x1 = Integer.parseInt(flip.substring(0, 1)) - 1;
        int y1 = Integer.parseInt(flip.substring(1, 2)) - 1;
        int x2 = Integer.parseInt(flip.substring(2, 3)) - 1;
        int y2 = Integer.parseInt(flip.substring(3, 4)) - 1;
        int x3 = Integer.parseInt(flip.substring(4, 5)) - 1;
        int y3 = Integer.parseInt(flip.substring(5, 6)) - 1;

        flip(matrix, x1, y1);
        flip(matrix, x2, y2);
        flip(matrix, x3, y3);

        System.out.print("[");
        for (int i = 0; i < 4; i++) {
            System.out.print("[");
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + ",");
                }
            }
            if (i == 3) {
                System.out.print("]");
            } else {
                System.out.print("],");
            }
        }
        System.out.print("]");

    }

    private static void flip(int[][] matrix, int x, int y) {
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                if (matrix[nx][ny] == 1) {
                    matrix[nx][ny] = 0;
                } else {
                    matrix[nx][ny] = 1;
                }
            }
        }
    }
}
