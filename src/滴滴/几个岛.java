package 滴滴;

/*  几个岛（LC 305）
    给定一个 m 行 n 列的二维地图，初始化每个单元都是水。
    操作 addLand 把单元格 (row, col) 变成陆地。
    岛屿定义为一系列相连的被水单元包围的陆地单元，横向或纵向相邻的陆地称为相连（斜对角不算）。
    在一系列 addLand 的操作过程中，给出每次 addLand 操作后岛屿的个数。
    二维地图的每条边界外侧假定都是水。

    输入描述:
    多组测试数据，请参考例题处理 每组数据k+3行, k表示addLand操作次数 第一行:表示行数m 第二行:表示列数n 第三行:表示addLand操作次数k 第4~k+3行:row col 表示addLand的坐标。注意超过边界的坐标是无效的。
    输出描述:
    一行,k个整数, 表示每次addLand操作后岛屿的个数, 用空格隔开，结尾无空格

    示例：
    输入：
    3
    3
    4
    0 0
    0 1
    1 2
    2 1
    输出：
    1 1 2 3
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*  Union Find

 */
public class 几个岛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int len = sc.nextInt();
        int[][] positions = new int[len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                positions[i][j] = sc.nextInt();
            }
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        boolean[] visited = new boolean[m * n];

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] pair : positions) {
            int r = pair[0];
            int c = pair[1];
            if (r < 0 || r >= m || c < 0 || c >= n) {
                res.add(count);
                continue;
            }
            int pos = r * n + c;
            if (visited[pos]) {
                res.add(count);
                continue;
            }
            visited[pos] = true;
            roots[pos] = pos;
            count++;

            for (int[] d : dirs) {
                int x = pair[0] + d[0];
                int y = pair[1] + d[1];
                int curPos = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[curPos] == -1) {
                    continue;
                }
                int anoIsland = find(roots, curPos);
                // Union 过程
                if (pos != anoIsland) {
                    roots[pos] = anoIsland;
                    // 合并完的 root 变成 curPos
                    pos = anoIsland;
                    count--;
                }
            }
            res.add(count);
        }
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else {
                System.out.print(res.get(i) + " ");
            }
        }
    }

    private static int find(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
