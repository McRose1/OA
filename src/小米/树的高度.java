package 小米;

/*  树的高度
    现在有一棵合法的树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度

    输入描述:
    输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
    下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
    输出描述:
    输出树的高度，为一个整数

    示例1
    输入
    5
    0 1
    0 2
    1 3
    1 4
    输出
    3
 */

import java.util.*;

public class 树的高度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tree = new int[n][n];
        boolean[] notRoot = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int children = sc.nextInt();
            tree[parent][children] = 1;
            notRoot[children] = true;
        }

        int rootId = -1;
        for (int i = 0; i < n; i++) {
            if (!notRoot[i]) {
                rootId = i;
                break;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(rootId);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (tree[cur][j] == 1) {
                        queue.offer(j);
                    }
                }
            }
        }
        System.out.print(height);
    }
}
