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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*  DFS + 剪枝
    剪枝关键在于每次 DFS 之前判断当前剩余的坑位数量和任意品种的树的数量之间的关系
    如果任意品种树的数量 > （坑位 + 1）/ 2 -> 直接 return false
 */
public class 种树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        if (N == 1 && nums[0] != 1) {
            System.out.println("-");
            return;
        }
        List<String> res = new ArrayList<>();
        if (dfs(0, nums, N, sum, res)) {
            for (String re : res) {
                System.out.print(Integer.parseInt(re) + " ");
            }
        } else {
            System.out.println("-");
        }
    }

    private static boolean dfs(int count, int[] nums, int N, int sum, List<String> res) {
        if (count == sum) {
            return true;
        }
        int remain = sum - count;
        // 剪枝
        for (int i = 1; i <= N; i++) {
            if (nums[i] > (remain + 1) / 2) {
                return false;
            }
        }
        // 满足字典序最小，从头往后遍历
        for (int i = 1; i <= N; i++) {
            // 保证相邻两树种类不同
            if (count == 0 || nums[i] != 0 && i != Integer.parseInt(res.get(count - 1))) {
                nums[i]--;
                res.add(i + "");
                if (dfs(count + 1, nums, N, sum, res)) {
                    return true;
                }
                // backtrack
                nums[i]++;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
