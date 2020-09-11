package 中兴;

/*  汇集
    给出一个 n 个点 m 条有向边的有向无环图，有一个点 x 为首都，现在需要从任何点出发都可以到达首都，问最少添加多少条边。

    保证给出的图没有重边和自环并且没有环。

    输入描述：
    第一行：n m x
    m 行每行 2 个空格 u v 用来描述一条有向边，代表可以从 u 出发到达 v
    1 <= n <= 10^5
    1 <= m < 2 x 10^5
    1 <= x, u, v <= n

    输出描述：
    一行一个正整数

    输入：
    3 1 1
    2 3

    输出：
    1

    说明：
    添加一条从 3 到 1 的边即可
 */

import java.util.*;

/*  Union Find (10%)

 */
public class 汇集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[][] edges = new int[n][n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int[] temp = new int[] {u, v};
            edges[i] = temp;
        }

        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
            }
        }

        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(uf.parent[i])) {
                set.add(uf.parent[i]);
                count++;
            }
        }
        System.out.println(--count);
    }

    private static class UF {
        int[] parent;
        int[] size;

        public UF(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        public int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int x_root = find(x);
            int y_root = find(y);
            if (size[x] > size[y]) {
                parent[y] = x;
                size[x] += size[y];
            } else {
                parent[x] = y;
                size[y] += size[x];
            }
        }
    }
}
