package 招商银行;

/*  LC 765
    在一场集体婚礼上，有n对新人需要坐在连续排列的 2n 个座位上合影，同一对新人彼此挨着。
    由于进场时各对新人并未按序入座，请计算最少交换座位的次数，以便使每对新人均可并肩坐在一起。
    一次交换可选择任意两人，让他们互换座位。
    全部新人的序号可用 0 到 2n-1 的整数表示，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2n-2, 2n-1)。
    row[i]指最初坐在第 i 个座位上的新人编号，i是从0到（2n-1）的一个升序全排列，row不存在重复值。

    输入描述:
    输入共有2行，第一行为n，即共有多少对新人(2 ≤ n ≤ 100000)，第二行为row，即2n个座位上的初始新人编号。
    输出描述:
    输出最少交换座位的次数。

    示例1
    输入
    2
    0 2 1 3
    输出
    1
    说明
    我们只需要交换1和2的位置即可

    示例2
    输入
    2
    3 2 0 1
    输出
    0
    说明
    无需交换座位，所有的新人都已经并肩坐在一起
 */

import java.util.Scanner;

public class 交换座位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            nums[i] = sc.nextInt();
        }

        // couples[x] = {i, j} means that couple #x is at couches i and j (1 indexed)
        int[][] couples = new int[n][2];

        for (int i = 0; i < nums.length; i++) {
            // row[i]/2 为情侣对#，i/2 + 1为沙发#
            add(couples[nums[i] / 2], i / 2 + 1);
        }
        // couples: [[1, 2], [1, 2]]

        // adj[x] = {i, j} means that x-th couch connected to couches i,j (all 1 indexed) by couples
        int[][] adj = new int[n + 1][2];
        for (int[] couple : couples) {
            add(adj[couple[0]], couple[1]);
            add(adj[couple[1]], couple[0]);
        }
        // adj: [[2, 2], [2, 2]]

        // The answer will be N minus the number of cycles in adj.
        int ans = n;
        // For each couch
        for (int r = 1; r <= n; r++) {
            // If this couch has no people needing to be paired, continue
            if (adj[r][0] == 0 && adj[r][1] == 0) {
                continue;
            }
            // Otherwise, there is a cycle starting at couch r.
            // We will use two pointers x, y with y faster than x by one turn.
            ans--;
            int x = r;
            int y = pop(adj[r]);
            // When y reaches the start 'r', we've reached the end of the cycle.
            while (y != r) {
                // We are at some couch with edges going to 'x' and 'new'.
                // We remove the previous edge, since we came from x.
                remove(adj[y], x);

                // We update x, y appropriately: y becomes new and x becomes y.
                x = y;
                y = pop(adj[y]);
            }
        }
        System.out.println(ans);
    }
    // Replace the next 0 element with x.
    private static void add(int[] pair, int x) {
        if (pair[0] == 0) {
            pair[0] = x;
        } else {
            pair[1] = x;
        }
    }
    // Remove x from pair, replacing it with 0.
    private static void remove(int[] pair, int x) {
        if (pair[0] == x) {
            pair[0] = 0;
        } else {
            pair[1] = 0;
        }
    }
    // Remove the next non-0 element from pair, replacing it with 0.
    private static int pop(int[] pair) {
        int x = pair[0];
        if (x != 0) {
            pair[0] = 0;
        } else {
            x = pair[1];
            pair[1] = 0;
        }
        return x;
    }
}
