package Robinhood;

/*  countSubsegments
    Given an array of non-negative integers arr, your task is to find the number of ways it can be split into three
    non-empty contiguous such that the sum of the elements in the first subarray is less than or equal to the sum of
    the elements in the second subarray, and the sum of the elements in the second subarray is less than or equal to
    the sum of the elements in the third subarray.

    Note:
        o Each element of arr must appear in exactly one of the three contiguous subarrays.
        o Although the given numbers are 32-bit integers, the sum of the elements may exceed the limits of the 32-bit integer type.

    Example:
        o For arr = [1, 1, 1], the output should be countSubsegments(arr) = 1.
          The only way to split this array into three non-empty contiguous subarrays is [1], [1], [1].
          This triple of subarrays satisfies the conditions (1 <= 1 <= 1), so the answer is 1.
        o For arr = [1, 2, 0], the output should be countSubsegments(arr) = 0.
        o For arr = [1, 2, 2, 2, 5, 0], the output should be countSubsegments(arr) = 3.
 */

import java.util.Scanner;

public class countSubsegments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (n < 3) {
            System.out.print(0);
            return;
        }

        int count = 0;
        long si = 0;
        for (int i = 0; i < n - 2; i++) {
            si += arr[i];
            long sj = 0;
            for (int j = i + 1; j < n - 1; j++) {
                sj += arr[j];
                if (si <= sj && sj <= (sum - si - sj)) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
