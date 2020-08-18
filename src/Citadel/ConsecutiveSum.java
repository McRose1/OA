package Citadel;

/*  Consecutive Sum (LC 829) res-1
    Given a long integer, find the number of ways to represent it as a sum of two or more consecutive positive integers.

    Example:
    num = 21

    There are three ways to represent num = 21 as the sum of two or more consecutive integers:
        o 1+2+3+4+5+6 = 21
        o 6+7+8 = 21
        o 10+11 = 21

    Function Description
    Complete the function consecutive in the editor below.

    consecutive has the following parameter(s):
    int num: the target sum

    Returns:
        int: the number of ways to represent num as a sum of two or more consecutive positive integers.
 */

import java.util.Scanner;

public class ConsecutiveSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(consecutiveSum(N));
    }

    static private int consecutiveSum(int N) {
        int res = 0;
        for (int i = 1; i * (i - 1) / 2 < N; i++) {
            if ((N - i * (i - 1) / 2) % i == 0) {
                res++;
            }
        }
        return res - 1;
    }
}
