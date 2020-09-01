package 欢聚集团;

/*  找下一个水仙花数
    给定任意一个正整数，求比这个数大且最小的“水仙花数”。
    “水仙花数”是指 N 位非负整数，其各位数字的 N 次方和等于该数本身。

    例如，个位数都是水仙花数，3 = 3（1 次方）。
    153 是水仙花数，153 = 1*1*1 + 5*5*5 + 3*3*3（3 次方）

    注：输入值不会超过 Integer.MAX_VALUE。

    输入：
    108
    输出：
    153

    输入：
    8
    输出：
    9
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 找下一个水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        len = input.length();
        int n = Integer.parseInt(input);
        long res = nextNarcissisticNumber(n);
        System.out.print(res);
    }

    private static int len;

    private static long nextNarcissisticNumber(int n) {
        if (n < 9) {
            return n + 1;
        } else if (n < 152) {
            return 153;
        } else {
            List<Long> list = narcissisticNumber(len);
            for (Long aLong : list) {
                if (aLong > n) {
                    return aLong;
                }
            }
        }
        return -1;
    }

    private static List<Long> narcissisticNumber(int len) {
        List<Long> list = new ArrayList<>();
        for (int i = 3; i <= len; i++) {
            long[] a = new long[i];
            long num = (long) Math.pow(10, i - 1) + 1;
            while (num <= Math.pow(10, i)) {
                long sum = 0;
                for (int j = 0; j < i; j++) {
                    a[j] = (long) (num / Math.pow(10, j) % 10);
                }
                for (int j = 0; j < i; j++) {
                    sum += (long) Math.pow(a[j], i);
                }
                if (num == sum) {
                    list.add(num);
                }
                num++;
            }
        }
        return list;
    }
}
