package 好未来;

/*  二叉树
    二叉树的非递归前序遍历

    输入：
    {1,2,3,4,5,#,#}

    输出：
    "1,2,4,5,3"
 */

import java.util.*;

public class 二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(notReCuPreOrder(root));
    }

    public static String notReCuPreOrder (TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                sb.append(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (i == sb.length() - 1) {
                res.append(sb.charAt(i));
            } else {
                res.append(sb.charAt(i));
                res.append(",");
            }
        }
        return res.toString();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}