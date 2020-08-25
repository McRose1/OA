package Robinhood;

/*  duplicatesOnSegment
    You are given an array of integers arr. Your task is to count the number of contiguous subarrays,
    such that each element of the subarray appears at least twice.

    Example:
        o For arr = [0, 0, 0], the output should be duplicatesOnSegment(arr) = 3.
          There are 3 subarrays that satisfy the criteria of containing only duplicate elements:
            o arr[0..1] = [0, 0]
            o arr[1..2] = [0, 0]
            o arr[0..2] = [0, 0, 0]
        o For arr = [1, 2, 1, 2, 3], the output should be duplicatesOnSegment(arr) = 1.
          There is only 1 applicable subarray: arr[0..3] = [1, 2, 1, 2].
 */

import java.util.HashMap;
import java.util.Scanner;

public class duplicatesOnSegment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(duplicatesOnSegment(arr));
    }

    private static int duplicatesOnSegment(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return 0;

    }
}
