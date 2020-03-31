package Nutanix;

/*  Colored Loops
    You are making an animated LED display for the opening of a festival,
    and you need to write a program to find connected loops of lights.
    Each light has a color represented by a corresponding alphabetic letter.
    The definition of a loop is that it connects two or more adjacent lights with the same color
    and has the same starting and end light.

    Example 1:
    Input:
    3 4
    AAAA
    ABCA
    AAAA
    Output:
    Yes
 */

import java.util.ArrayList;
import java.util.List;

public class ColoredLoops {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean findLoop(char[][] grid) {
        List<Character> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] == 0 && dfs(grid, visited, r, c, -1, -1, grid[r][c])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int[][] visited, int r, int c, int prev_r, int prev_c, char color) {
        int m = grid.length, n = grid[0].length;
        visited[r][c] = 1;

        for (int[] d : dirs) {
            int new_r = r + d[0];
            int new_c = c + d[1];
            if (new_r == prev_r && new_c == prev_c) {
                continue;
            }
            if (new_r >= 0 && new_c >= 0 && new_r < m && new_c < n &&
                    visited[new_r][new_c] == 1 && grid[new_r][new_c] == color) {
                if (visited[new_r][new_c] == 1 ||
                        (visited[new_r][new_c] == 0) && dfs(grid, visited, new_r, new_c, r, c, color)) {
                    return true;
                }
            }
        }
        visited[r][c] = 2;
        return false;
    }
}
