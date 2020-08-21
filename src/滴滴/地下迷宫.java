package 滴滴;

/*  地下迷宫
    小青蛙有一天不小心落入了一个地下迷宫，小青蛙希望用自己仅剩的体力值 P 跳出这个地下迷宫。
    为了让问题简单，假设这是一个 n*m 的格子迷宫，迷宫每个位置为 0 或者 1，
    0 代表这个位置有障碍物，小青蛙到达不了这个位置；1 代表小青蛙可以到达的位置。
    小青蛙初始在 (0,0) 位置，地下迷宫出口在 (0,m-1)（保证这两个位置都是 1，并且保证一定有起点到终点可达的路径），
    小青蛙在迷宫中水平移动一个单位距离需要消耗 1 点体力值，向上爬一个单位距离需要消耗 3 个单位的体力值，向下移动不消耗体力值，
    当小青蛙的体力值等于 0 的时候还没有到达出口，小青蛙将无法逃离迷宫。
    现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫（即到达(0,m-1)位置）。

    输入描述:
    输入包括n+1行:
     第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
     接下来的n行:
     每行m个0或者1,以空格分隔
    输出描述:
    如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一

    示例：
    输入：
    4 4 10
    1 0 0 1
    1 1 0 1
    0 1 1 1
    0 0 1 1
    输出：
    [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */

import java.util.Scanner;

/*  DFS

 */
public class 地下迷宫 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int P = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        dfs(n, m, P, maze, 0, 0, "", new boolean[n][m]);
        System.out.println(path);
    }

    static String path = "";

    private static void dfs(int n, int m, int P, int[][] maze, int nx, int ny, String res, boolean[][] visited) {
        if (nx == 0 && ny == m - 1) {
            if (P >= 0) {
                path = res + "[0," + (m - 1) + "]";
            } else {
                path = "Can not escape!";
            }
        }

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            res += "[" + nx + "," + ny + "],";
            dfs(n, m, P - 1, maze, nx, ny + 1, res, visited);
            dfs(n, m, P - 1, maze, nx, ny - 1, res, visited);
            dfs(n, m, P, maze, nx + 1, ny, res, visited);
            dfs(n, m, P - 3, maze, nx - 1, ny, res, visited);
        }
    }
}
