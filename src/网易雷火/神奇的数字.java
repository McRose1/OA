package 网易雷火;

/*  神奇的数字
    如果一个 N 位的数字满足以下条件，我们认为这是一个神奇数字：
    1. N 位的十进制数字，每一位是[0,9]，特别的，我们允许前序 0 存在。因此 1234 和 0012 都是合法的 4 位数
    2. 将每一位的数字加起来的和刚好等于 S
    3. 在这个 N 位的数字串中，任意的连续三位数字构成的三位数都能被 X 整除

    给定 N，S，X 的情况下，请求出满足以上条件的神奇数字一共有多少个

    输入描述：
    三个整数：N（3 <= N <= 50），S（0 <= S <= N*9），X（1 <= X <= 999）

    输出描述：
    满足以上条件的数字总数 mod 1000009
    因为这个总数可能很大，所以请输出这个总数模 1000009 的结果即可

    输入例子：
    4 3 3
    输出例子：
    6
    说明：
    3000
    0300
    0030
    0003
    0120
    0210
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//  Backtracking (10%)
public class 神奇的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int X = sc.nextInt();

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, N, S, X, new ArrayList<>());
        System.out.println(res.size() % 1000009);
    }

    private static void backtrack(List<List<Integer>> res, int count, int target, int X, List<Integer> list) {
        if (count == 0) {
            if (target == 0) {
                if (isValid(list, X)) {
                    res.add(new ArrayList<>(list));
                }
            }
            return;
        }
        int max = Math.min(target, 9);
        for (int i = 0; i <= max; i++) {
            list.add(i);
            backtrack(res, count - 1, target - i, X, list);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isValid(List<Integer> list, int X) {
        for (int i = 0; i <= list.size() - 3; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(list.get(i)));
            for (int j = i + 1; j < i + 3; j++) {
                sb.append(list.get(j));
            }
            int idx = 0;
            while (idx < sb.length() && sb.charAt(idx) == '0') {
                idx++;
            }
            if (idx != sb.length()) {
                int num = Integer.parseInt(sb.substring(idx));
                if (num % X != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
