package 中兴;

/*  牛牛的完全二叉树
    一颗 n 个节点的完全二叉树，给我们这棵树的层次遍历每个节点的值，对这颗树进行操作：
        1. 对编号为 x 的节点（注意不是节点值为 x 的点）与其左右儿子进行从大到小重排序，排序结果使得 root >= left >= right
        2. 按顺序输出第 x 层的节点值

    输入描述：
    第一行： n（表示二叉树节点个数） m（表示操作次数）
    第二行：n 个数字 ai，表示二叉树层次遍历的各个节点值
    接下来 m 行，每行有 2 个数字 op 和 x
    1 <= n <= 10^6
    1 <= m <= 10^3
    1 <= ai <= n

    输出描述：
    当 op == 2 时，输出为一行，按顺序输出第 x 层的节点值

    示例 1：
    输入：
    11 3
    1 2 3 4 5 6 7 8 9 10 11
    1 4
    1 5
    2 4

    输出：
    8 4 10 5

    示例 2：
    输入：
    10 5
    4 3 2 1 5 7 8 9 10 6
    1 3
    1 5
    1 7
    1 10
    2 3

    输出：
    1 6 7 2
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 牛牛的完全二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        buildTree(nums);

        int[][] ops = new int[m][2];
        for (int i = 0; i < m; i++) {
            ops[i][0] = sc.nextInt();
            ops[i][1] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if (ops[i][0] == 1) {
                int x = ops[i][1];

            }
        }
    }

    private static void buildTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        int idx = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && idx < nums.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (idx < nums.length) {
                    node.left = new TreeNode(nums[idx++]);
                    queue.offer(node.left);
                }
                if (idx < nums.length) {
                    node.right = new TreeNode(nums[idx++]);
                    queue.offer(node.right);
                }
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
