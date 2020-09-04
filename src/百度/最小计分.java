package 百度;

/*  最小计分
    小度最近在研究一个棋盘游戏，游戏规则如下：
    一个N*N的棋盘，每个格子里面填写有1、2、3、4这四个数字中的某一个。
    最开始时在第1行第1列（左上角）放置一个棋子。每次棋子可以移动至上、下、左、右四个格子中的某一个，
    每次只能移动一格（允许重复移动到某一个格子），在任何时刻都不允许将棋子移出棋盘。

    在移动时需要进行计分。如果初始格子中的数字为X，目标格子中的数字为Y，则本次移动计分为|X-Y|（取X-Y的绝对值），即两个格子中的数字之差。

    现在需要把棋子移动到第N行第N列（右下角），请问能够获得的最小计分为多少？

    输入：
    单组输入。
    第1行为N。（1≤N≤100）
    接下来N行为一个二维数组，表示棋盘上每一个格子及其对应的数字（正整数）。

    输出：
    输出一个正整数，表示最小计分。

    样例输入
    3
    1 2 4
    1 3 1
    1 2 1
    样例输出
    2
 */

import java.util.Scanner;

/*  55%

 */
public class 最小计分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        if (N == 1) {
            System.out.print(0);
            return;
        }
        dfs(board,0, 0, 0);
        System.out.print(min);
        /*
        int[][] dp = new int[N][N];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + Math.abs(board[i][0] - board[i - 1][0]);
        }
        for (int j = 1; j < N; j++) {
            dp[0][j] = dp[0][j - 1] + Math.abs(board[0][j] - board[0][j - 1]);
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + Math.abs(board[i][j] - board[i - 1][j]), dp[i][j - 1] + Math.abs(board[i][j] - board[i][j - 1]));
            }
        }

        System.out.print(dp[N - 1][N - 1]);

         */
    }

    private static int min = Integer.MAX_VALUE;
    private static int N;

    private static void dfs(int[][] board, int i, int j, int score) {
        if (board[i][j] == 0) {
            return;
        }

        if (i == N - 1 && j == N - 1) {
            min = Math.min(min, score);
            return;
        }

        int temp = board[i][j];
        board[i][j] = 0;

        if (i + 1 < N) {
            int down = board[i + 1][j];
            dfs(board, i + 1, j, score + Math.abs(temp - down));
        }

        if (i - 1 >= 0) {
            int up = board[i - 1][j];
            dfs(board, i - 1, j, score + Math.abs(temp - up));
        }

        if (j + 1 < N) {
            int right = board[i][j + 1];
            dfs(board, i, j + 1, score + Math.abs(temp - right));
        }

        if (j - 1 >= 0) {
            int left = board[i][j - 1];
            dfs(board, i, j - 1, score + Math.abs(temp - left));
        }
    }
}
