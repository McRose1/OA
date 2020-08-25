package Robinhood;

/*  A sawtooth sequence is a sequence of numbers that alternate between increasing and decreasing.
    In other words, each element is either strictly greater than its neighboring elements or strictly less than its neighbouring elements.

    Given an array of integers arr, your task is to count the number of contiguous subarrays that represent
    a sawtooth sequence of at least two elements.

    Example:
    o For arr = [9, 8, 7, 6, 5], the output should be countSawSubarrays(arr) = 4.
      Since all the elements are arranged in decreasing order, it won't be possible to from any sawtooth
      subarrays of length 3 or more. There are 4 possible subarrays containing two elements, so the answer is 4.
    o For arr = [10, 10, 10], the output should be countSawSubarrays(arr) = 0.
      Since all of the elements are equal none of subarrays can be sawtooth, so the answer is 0.
    o For arr = [1, 2, 1, 2, 1], the output should be countSawSubarrays(arr) = 10.
      All contiguous subarrays containing at least two elements satisfy the condition of problem.
      There are 10 possible contiguous subarrays containing at least two elements, so the answer is 10.
 */

import java.util.Scanner;

public class sawtooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countSawSubarrays(arr));
    }

    public static int countSawSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean increase = false;
            boolean decrease = false;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[j - 1]) {
                    continue;
                } else if (!increase && !decrease) {
                    if (arr[j] > arr[j - 1]) {
                        increase = true;
                    } else if (arr[j] < arr[j - 1]) {
                        decrease = true;
                    }
                    count++;
                } else if (increase) {
                    if (arr[j] < arr[j - 1]) {
                        decrease = true;
                        increase = false;
                        count++;
                    } else {
                        break;
                    }
                } else {
                    if (arr[j] > arr[j - 1]) {
                        increase = true;
                        decrease = false;
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
