package 便利蜂;

/*  整数分解
    给定一个正整数数n, 一个正整数k 一个可行的数字组合是一组正整数， 它们的和为n，且组合中的数字个数小于等于k, 组合中允许数字重复出现

    输出：所有可能的组合数 (两个组合中出现的数字相同，顺序不同计为同一个）

    输入描述
    public int numOf (int n, int k )
    说明：
    n：组合累加和
    k：最多可以使用的正整数个数

    输出描述
    返回：组合数

    样例输入
    5
    2
    样例输出
    3

    提示
    5=5
    5=1+4
    5=2+3
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 整数分解 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        max = n;
        for (int i = 1; i <= k; i++) {
            backtrack(n, i, 1);
        }
        System.out.println(count);
    }

    private static int count = 0;
    private static int max = Integer.MIN_VALUE;
    private static List<List<Integer>> res = new ArrayList<>();

    private static void backtrack(int sum, int cnt, int start) {
        if (cnt == 0) {
            if (sum == 0) {
                count++;
            }
            return;
        }
        if (sum < start) {
            return;
        }

        for (int i = start; i <= max; i++) {
            backtrack(sum - i, cnt - 1, i);
        }
    }
}
