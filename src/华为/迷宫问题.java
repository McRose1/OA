package 华为;

/*  迷宫问题
    定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：

    int maze[5][5] = {
            0, 1, 0, 0, 0,
            0, 1, 0, 1, 0,
            0, 0, 0, 0, 0,
            0, 1, 1, 1, 0,
            0, 0, 0, 1, 0,
    };

    它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。
    入口点为[0,0],既第一空格是可以走的路。

    Input
    一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

    Output
    左上角到右下角的最短路径，格式如样例所示。

    Sample Input
    0 1 0 0 0
    0 1 0 1 0
    0 0 0 0 0
    0 1 1 1 0
    0 0 0 1 0

    Sample Output
    (0, 0)
    (1, 0)
    (2, 0)
    (2, 1)
    (2, 2)
    (2, 3)
    (2, 4)
    (3, 4)
    (4, 4)

    输入描述:
    输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。
    数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

    输出描述:
    左上角到右下角的最短路径，格式如样例所示。

    示例1
    输入
    5 5
    0 1 0 0 0
    0 1 0 1 0
    0 0 0 0 0
    0 1 1 1 0
    0 0 0 1 0
    输出
    (0,0)
    (1,0)
    (2,0)
    (2,1)
    (2,2)
    (2,3)
    (2,4)
    (3,4)
    (4,4)
 */

import java.util.*;

public class 迷宫问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        dfs(maze, 0, 0, new ArrayList<>());
        res.sort((a, b) -> a.size() - b.size());
        for (int i = 0; i < res.get(0).size(); i++) {
            System.out.println("(" + res.get(0).get(i)[0] + "," + res.get(0).get(i)[1] + ")");
        }
    }

    private static int row;
    private static int col;
    private static List<List<int[]>> res = new ArrayList<>();

    private static void dfs(int[][] maze, int x, int y, List<int[]> path) {
        if (x == row - 1 && y == col - 1) {
            path.add(new int[] {x, y});
            res.add(new ArrayList<>(path));
            return;
        }
        if (x < 0 || x >= row || y < 0 || y >= col || maze[x][y] == 1) {
            return;
        }
        maze[x][y] = 1;
        path.add(new int[] {x, y});
        dfs(maze, x + 1, y, path);
        dfs(maze, x - 1, y, path);
        dfs(maze, x, y + 1, path);
        dfs(maze, x, y - 1, path);
        path.remove(path.size() - 1);
        maze[x][y] = 0;
    }
}
