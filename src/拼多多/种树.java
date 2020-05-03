package 拼多多;

/*  种树
    小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。
    小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。但是他希望任意两棵相邻的树不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。

    输入描述：
    第一行包含一个正整数 N，表示树的品种数量。
    第二行包含 N 个正整数，第 i (1 <= i <= N) 个数表示第 i 个品种的树的数量。
    数据范围：
    1 <= N <= 1000
    1 <= M <= 2000

    输出描述：
    输出一行，包含 M 个正整数，分别表示第 i 棵树的品种编号 (品种编号从 1 到 N)。若存在多种可行方案，则输出字典序最小的方案。若不存在满足条件的方案，则输出"-"。

    输入例子：
    3
    4 2 1

    输出例子：
    1 2 1 2 1 3 1
 */

import java.util.Scanner;

public class 种树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        if (N == 1 && nums[0] != 1) {
            System.out.println("-");
            return;
        }
        int[] res = new int[sum];
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            for (int k = 0; k < sum; k++) {
                res[k] = nums[i];

            }
        }
    }
}
