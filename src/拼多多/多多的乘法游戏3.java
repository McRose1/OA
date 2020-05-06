package 拼多多;

import java.util.Scanner;

public class 多多的乘法游戏3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int len = 1; len <= N; len++) {
            for (int i = 0; i < N; i++) {
                max = Math.max(max, len * gcdHelper(nums, nums[i], len));
            }
        }
        System.out.println(max);
    }

    private static int gcdHelper(int[] nums, int start, int len) {
        int[] dp = new int[len];
        if (len == 1) {
            return nums[start];
        } else if (len == 2) {
            return gcd(nums[start], nums[start + 1]);
        } else {
            return -1;
        }

    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a == b) {
            return a;
        }
        if (a < b) {
            gcd(b, a);
        }
        return gcd(b, a % b);
    }
}
