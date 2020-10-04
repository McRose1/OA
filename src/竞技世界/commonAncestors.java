package 竞技世界;

/*  commonAncestors
    输入一个数组表示完全二叉树（数组中的值不重复），给定两个值（两个值不相等），
    求这两个值所在节点的最近公共祖先节点的值（如果这两个值没有找到对应节点，返回-1）。

    输入：
    [5,2,4,1,6,9,0,3],3,6
    输出：
    2

    输入：
    [8,2,5,6,4,7,1,3],2,3
    输出：
    2
 */

import java.util.ArrayList;
import java.util.List;

public class commonAncestors {
    public static void main(String[] args) {
        int[] tree1 = new int[] {8,2,5,6,4,7,1,3};
        int v11 = 11;
        int v21 = 3;
        System.out.println(commonAncestors(tree1, v11, v21));

        int[] tree2 = new int[] {5,2,4,1,6,9,0,3};
        int v12 = 3;
        int v22 = 6;
        System.out.println(commonAncestors(tree2, v12, v22));
    }

    public static int commonAncestors(int[] tree, int v1, int v2) {
        if (tree == null || tree.length < 2) {
            return -1;
        }
        boolean v1Exist = false;
        boolean v2Exist = false;
        for (int val : tree) {
            if (val == v1) {
                v1Exist = true;
            }
            if (val == v2) {
                v2Exist = true;
            }
        }

        if (!v1Exist || !v2Exist) {
            return -1;
        }

        TreeNode root = buildTree(tree);

        TreeNode parent = helper(root, v1, v2);
        return parent == null ? -1 : parent.val;
    }

    private static TreeNode helper(TreeNode root, int v1, int v2) {
        if (root == null || root.val == v1 || root.val == v2) {
            return root;
        }

        TreeNode left = helper(root.left, v1, v2);
        TreeNode right = helper(root.right, v1, v2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    private static TreeNode buildTree(int[] tree) {
        List<TreeNode> list = new ArrayList<>();
        for (int j : tree) {
            list.add(new TreeNode(j));
        }
        int idx = 0;
        while (idx <= (tree.length - 2) / 2) {
            if (idx * 2 + 1 < tree.length) {
                list.get(idx).left = list.get(idx * 2 + 1);
            }
            if (idx * 2 + 2 < tree.length) {
                list.get(idx).right = list.get(idx * 2 + 2);
            }
            idx++;
        }
        return list.get(0);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
