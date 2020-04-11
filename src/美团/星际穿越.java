package 美团;

/*  星际穿越
    小团在一次星际旅行中，耗尽了飞船的能量，迷失在了空间魔方中，空间魔方中有 N*N*N 个能量粒子。美团云 AI 迅速帮小团分析出了空间魔方的能量分布图。
    已知小团的飞船被困在能量值最高的点，能量值最高点有且只有一个。飞船每到达一个能量粒子就会吸收对应粒子的能量，该粒子会坍缩成小黑洞，飞船不可到达。
    小团驾驶的飞船只能从高能粒子驶向低能粒子，且每次只能从 6 个方向中选择一个前进。（+-x, +-y, +-z）。
    请帮助小团吸收最高的能量值。

    输入描述：
    N（0<=N<=8）
    N*N*N 行空间能量数据，格式为 X Y Z P, XYZ 表示点坐标，P 表示空间能量分布（0<=P）

    输出描述：
    输出一个整数，表示可吸收到的最高的能量值

    输入例子 1：
    2
    0 0 0 7
    0 0 1 2
    0 1 0 4
    0 1 1 3
    1 0 0 6
    1 0 1 1
    1 1 0 5
    1 1 1 0

    输出例子 1：
    28

    输入例子 2：
    3
    0 0 0 1
    0 0 1 2
    0 0 2 3
    0 1 0 4
    0 1 1 5
    0 1 2 6
    0 2 0 7
    0 2 1 8
    0 2 2 9
    1 0 0 10
    1 0 1 11
    1 0 2 12
    1 1 0 13
    1 1 1 14
    1 1 2 13
    1 2 0 12
    1 2 1 11
    1 2 2 10
    2 0 0 9
    2 0 1 8
    2 0 2 7
    2 1 0 6
    2 1 1 5
    2 1 2 4
    2 2 0 3
    2 2 1 2
    2 2 2 1

    输出例子 2：
    89
 */
import java.util.Scanner;

//  DFS + Backtracking
public class 星际穿越 {
    private static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    private static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();
        Scanner lineScanner = new Scanner(line);
        int N = lineScanner.nextInt();
        if (N == 0) {
            System.out.println(max);
            return;
        }
        int[][][] graph = new int[N][N][N];
        int maxP = 0;
        int startX = 0;
        int startY = 0;
        int startZ = 0;
        for (int i = 0; i < N * N * N; i++) {
            line = sc.nextLine();
            lineScanner = new Scanner(line);
            int X = lineScanner.nextInt();
            int Y = lineScanner.nextInt();
            int Z = lineScanner.nextInt();
            int P = lineScanner.nextInt();
            graph[X][Y][Z] = P;
            // 寻找起点
            if (P > maxP) {
                startX = X;
                startY = Y;
                startZ = Z;
                maxP = P;
            }
        }
        dfs(graph, N, startX, startY, startZ, 0);
        System.out.println(max);
    }

    private static void dfs(int[][][] graph, int N, int X, int Y, int Z, int cur) {
        cur += graph[X][Y][Z];
        for (int[] dir : dirs) {
            int nextX = X + dir[0];
            int nextY = Y + dir[1];
            int nextZ = Z + dir[2];
            if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= N || nextY >= N || nextZ >= N ||
            graph[nextX][nextY][nextZ] == -1 || graph[nextX][nextY][nextZ] >= graph[X][Y][Z]) {
                continue;
            }
            int temp = graph[X][Y][Z];
            // 防止再次 visit
            graph[X][Y][Z] = -1;
            dfs(graph, N, nextX, nextY, nextZ, cur);
            // backtrack
            graph[X][Y][Z] = temp;
        }
        max = Math.max(max, cur);
    }
}
