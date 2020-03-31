package 乐元素;

/*  二叉搜索树的后序遍历序列
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    如果是则返回 true，否则返回 false。
    假设输入的数组的任意两个数字都互不相同。

    参考以下这颗二叉搜索树:
         5
        / \
       2   6
      / \
     1   3

    示例 1：
    输入: [1,6,3,2,5]
    输出: false

    示例 2：
    输入: [1,3,2,6,5]
    输出: true

    提示：
    数组长度 <= 1000
 */
/*  Divide and Conquer (Recursion): Time = O(n^2) Space = O(n)
    Postorder: [left | right | root]
    终止条件：i >= j，说明子树节点少于或等于 1 个，无需判别正确性，直接返回 true
    递推工作：
    1. 划分左右子树：遍历数组，寻找第一个大于根节点（postorder(j)）的节点，index 记为 m
    可划分出左子树区间[i, m - 1]、右子树区间[m, j - 1]、根节点 index j
    2. 判断是否满足二叉搜索树性质：
        右子树区间[i, j - 1] 内的所有元素都应 > postorder[j]
        左子树区间[i, m - 1] 内的所有元素都应 < postorder[j]
    [1, 3, 2,| 6,| 5]
      left     m  right
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] po, int i, int j) {
        if (i >= j) return true;
        int index = i;
        while (po[index] < po[j]) {
            index++;
        }
        int m = index;
        while (po[index] > po[j]) {
            index++;
        }
        // 分别判断此树是否正确，和此树的左右子树是否正确
        return index == j && recur(po, i, m - 1) && recur(po, m, j - 1);
    }
}

/*  Iteration(单调栈): Time = O(n) Space = O(n)
    Postorder 的倒序：[root | right | left] 类似 Preorder 的镜像 (root|left|right)
    当 ri > r(i+1)时：ri 一定是 r(i+1)的右子节点
    当 ri < r(i+1)时：ri 一定是某节点 root 的左子节点, root 为节点 r(i+1)->r(n) 中值大于且最接近ri的节点
    借助单调递增栈，每当遇到值递减的节点ri，则通过出栈来寻找节点ri的 root；并每轮判断 ri 和 root 的关系
    倒序以后：[5, 6, 2, 3, 1]，找到第一个降序的节点 ri，则必有：
    ri 的 root 为左边最接近它的值的节点
    ri 右边的所有节点都应该小于 ri 的父节点

        Stack<Integer> stack = new Stack<>();       [1, 3, 2, 6, 5]
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 倒序数组里， root 右边的节点都要比 root 小
            if (postorder[i] > root) return false;              // 2; 3; 1
            // 通过 while 循环以及栈顶出栈最大的数来找到大于当前节点并且最为接近的节点，即为当前节点的 root
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();             // root = 6; 5; 3; 2
            }
            stack.add(postorder[i]);        // 5; 6; 2; 2,3; 1
        }
        return true;
 */
