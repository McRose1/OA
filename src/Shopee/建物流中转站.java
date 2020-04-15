package Shopee;

/*  建物流中转站
    Shopee 物流会有很多个中转站。在选址的过程中，会选择离用户最近的地方建一个物流中转站。
    假设给你一个二维平面网格。每个格子是房子则为 1，或者是空地则为 0.找到一个空地修建一个物流中转站，使得这个物流中转站到所有的房子的距离之和最小。
    能修建，则返回最小的距离和。如果无法修建，则返回 -1。
    若范围限制在 100*100 以内的网格，如何计算出最小的距离和？
    当平面网格非常大的情况下，如何避免不必要的计算？

    输入描述：
    4
    0 1 1 0
    1 1 0 1
    0 0 1 0
    0 0 0 0
    先输入方阵阶数，然后逐行输入房子和空地的数据，以空格分隔。

    输出描述：
    8
    能修建，则返回最小的距离和。如果无法修建，则返回-1。

    输入例子 1：
    4
    0 1 1 0
    1 1 0 1
    0 0 1 0
    0 0 0 0

    输出例子 1：
    8

    输入例子 2：
    4
    1 1 1 1
    1 1 1 1
    1 1 1 1
    1 1 1 1

    输出例子 2：
    -1
 */

import java.util.*;

public class 建物流中转站 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                // 记录房屋的坐标，作为辅助
                if (grid[i][j] == 1) {
                    int[] house = new int[2];
                    house[0] = i;
                    house[1] = j;
                    list.add(house);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int distance = 0;
                // 遍历所有的空地
                if (grid[i][j] == 0) {
                    for (int[] pos : list) {
                        // 计算两个坐标的曼哈顿距离
                        distance += Math.abs(pos[0] - i) + Math.abs(pos[1] - j);
                    }
                    res = Math.min(res, distance);
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}

/*  超时解法：BFS（想复杂了）
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    // 从每个 0 开始 BFS
                    queue.offer(new int[] {i, j});
                    int step = 1;
                    boolean[][] visited = new boolean[n][n];

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] cur = queue.poll();

                            for (int[] d : dirs) {
                                int new_r = cur[0] + d[0];
                                int new_c = cur[1] + d[1];
                                // 检查新的 index 是否在边界以内，以及没有被 visit 过
                                if (new_r >= 0 && new_c >= 0 && new_r < n && new_c < n && !visited[new_r][new_c]) {
                                    visited[new_r][new_c] = true;
                                    queue.offer(new int[] {new_r, new_c});
                                    if (grid[new_r][new_c] == 1) {
                                        distance[i][j] += step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result = Math.min(result, distance[i][j]);
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
 */