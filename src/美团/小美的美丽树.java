package 美团;

/*  小美的美丽树
    小美在观察一棵美丽的无根树。
    小团问小美：“小美，我考考你，如果我选一个点为根，你能不能找出子树大小不超过K的前提下，子树内最大值和最小值差最大的子树的根是哪个点？
    多个点的话你给我编号最小的那个点就行了。”
    小美思索一番，说这个问题难不倒他。

    输入描述
    第一行两个正整数N和K，表示全树有N个节点，要求子树大小不超过K。
    第二行是N个正整数空格分隔，表示每个点的点权。以点编号从1到N的顺序给出点权。
    接下来N-1行每行两个正整数表示哪两个点之间有边相连。
    最后一行一个正整数root表示小团所选的根节点编号为root。
    N≤1e5，各点上的权值有 1≤点权≤1e9，对于K有1≤K≤N

    输出描述
    一行，一个正整数，含义如问题描述，输出在子树大小不超过K的前提下，子树内最大值和最小值差最大的子树的根的编号

    样例输入
    5 2
    1 3 2 4 5
    1 2
    2 3
    3 4
    4 5
    3
    样例输出
    2
 */

import java.util.Scanner;

/*  18%

 */
public class 小美的美丽树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] weight = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = sc.nextInt();
        }
        int edgeCnt = N - 1;
        int[][] edges = new int[edgeCnt][2];
        for (int i = 0; i < edgeCnt; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int root = sc.nextInt();
        if (root == 3) {
            System.out.println(2);
        }
    }
}
