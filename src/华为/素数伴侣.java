package 华为;

/*  素数伴侣
    若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
    现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，
    例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，
    而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，
    当然密码学会希望你寻找出“最佳方案”。

    输入:
    有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。

    输出:
    输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。

    输入描述:
    输入说明
    1 输入一个正偶数n
    2 输入n个整数

    输出描述:
    求得的“最佳方案”组成“素数伴侣”的对数。

    示例1
    输入
    4
    2 5 6 13
    输出
    2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 素数伴侣 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        int count = 0;
        int[] match = new int[even.size()];
        for (Integer integer : odd) {
            boolean[] used = new boolean[even.size()];
            if (find(integer, even, used, match)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean find(int x, List<Integer> even, boolean[] used, int[] match) {
        for (int j = 0; j < even.size(); j++) {
            if (isPrime(x + even.get(j)) && !used[j]) {
                used[j] = true;
                // 如果第 j 个偶数没有伴侣，则直接将奇数 x 设为它的伴侣
                // 如果第 j 个偶数原来有伴侣的话，如果它的原伴侣能够重新找到伴侣，则将奇数 x 设为它的伴侣
                if (match[j] == 0 || find(match[j], even, used, match)) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
