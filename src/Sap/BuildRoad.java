package Sap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildRoad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String temp = sc.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = temp.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '$') {
                    count++;
                }
            }
        }
        int pair = 0;
        count--;
        while (count > 0) {
            pair += count;
            count--;
        }
        int[][] connections = new int[pair][3];
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '$') {
                    int idx = i * c + j;
                    queue.offer(idx);
                }
            }
        }
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int dist = 0;
            int x = idx / c;
            int y = idx % c;
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] != '#') {
                    int nIdx = nx * c + ny;

                }
            }
        }
    }

    static int[] parent;
    static int component;

    static private int find (int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    static private void connect(int x, int y) {
        if (find(x) == find(y)) {
            return;
        }
        int root = find(x);
        while (y != parent[y]) {
            int temp = parent[y];
            parent[y] = root;
            y = temp;
        }
        --component;
        parent[y] = root;
    }

    static private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    static public int minCosttoConnectAllNodes(int n, int[][] edges, int[][] newEdges) {
        return 0;
    }
}
