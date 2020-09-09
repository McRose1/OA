package 小米;

/*  小米Git
    git是一种分布式代码管理工具，git通过树的形式记录文件的更改历史，比如： base'<--base<--A<--A' ^ | --- B<--B'
    小米工程师常常需要寻找两个分支最近的分割点，即base.
    假设git 树是多叉树，请实现一个算法，计算git树上任意两点的最近分割点。
    （假设git树节点数为n,用邻接矩阵的形式表示git树：字符串数组matrix包含n个字符串，每个字符串由字符'0'或'1'组成，长度为n。
    matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。节点0为git树的根节点。）

    输入
    [01011,10100,01000,10000,10000],1,2
    输出
    1
 */

import java.util.*;

public class 小米Git {

    public static void main(String[] args) {
        String[] matrix = new String[] {"01011", "10100", "01000", "10000", "10000"};
        int indexA = 1;
        int indexB = 2;
        int res = getSplitNode(matrix, indexA, indexB);
        System.out.print(res);
    }

    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
        if (indexA == indexB) return indexA;
        int n = matrix.length;

        // 构造一个 father 数组，存放每个点的父节点
        int[] father = new int[n];
        // 根节点
        father[0] = -1;

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            char[] ch = matrix[parent].toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (!visited[i] && ch[i] == '1') {
                    father[i] = parent;
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        int ia = indexA;
        int ib = indexB;

        // 记录从根节点到本节点的路径
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        while (ia != -1) {
            stackA.push(ia);
            ia = father[ia];
        }
        while (ib != -1) {
            stackB.push(ib);
            ib = father[ib];
        }

        // 找到最近的公共父节点
        int common = 0;
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek().equals(stackB.peek())) {
            common = stackA.peek();
            stackA.pop();
            stackB.pop();
        }
        return common;
    }
}
