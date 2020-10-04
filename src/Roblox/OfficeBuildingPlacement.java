package Roblox;

/*  OfficeBuildingPlacement

    Example 1:
    w = 3, h = 2, n = 2
    Two buildings (zeros) have to be optimally placed. One of the optimal plan for this case is:

    01
    11
    10

    Answer: 1
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OfficeBuildingPlacement {
    static int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int findMinDistance(int w, int h, int n) {
        int[][] grid = new int[w][h];
        for (int i = 0; i < w; i++) {
            Arrays.fill(grid[i], -1);
        }
        return solve(n, w, h, 0, 0, grid);
    }

    private static int solve(int left, int w, int h, int row, int col, int[][] grid) {
        if (left == 0) {
            return bfs(w, h, grid);
        }
        int r = row;
        int c = col;
        if (col >= h) {
            r += col / h;
            c = col % h;
        }
        int min = Integer.MIN_VALUE;
        for (int i = r; i < w; i++) {
            for (int j = c; j < h; j++) {
                grid[i][j] = 0;
                int val = solve(left - 1, w, h, i, j + 1, grid);
                min = Math.min(min, val);
                grid[i][j] = -1;
            }
        }
        return min;
    }

    private static int bfs(int w, int h, int[][] grid) {
        int[][] dist = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                dist[i][j] = grid[i][j];
            }
        }
        int max = 0;
        Queue<Loc> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (dist[i][j] == 0) {
                    queue.add(new Loc(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.peek().first;
            int y = queue.peek().second;
            max = Math.max(max, dist[x][y]);
            queue.poll();
            for (int[] d : dirs) {
                int new_x = x + d[0];
                int new_y = y + d[1];
                if (new_x < 0 || new_x >= w || new_y < 0 || new_y >= h) {
                    continue;
                }
                if (dist[new_x][new_y] == -1) {
                    dist[new_x][new_y] = dist[x][y] + 1;
                    queue.offer(new Loc(new_x, new_y));
                }
            }
        }
        return max;
    }

    private static class Loc{
        int first;
        int second;
        public Loc(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
