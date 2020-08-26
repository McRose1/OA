package Robinhood;

/*  oppositeSums
    Consider a function rev which reverses the digits in an integer.
    Here are some examples:
        o rev(103) = 301
        o rev(2400) = 42
        o rev(9) = 9
    Given an array of non-negative integers arr, your task is to count the number of pairs (i, j) such that
    i <= j and arr[i] + rev(arr[j]) = arr[j] + rev(arr[i]).

    Example:
        o For arr = [1, 20, 2, 11], the output should be oppositeSums(arr) = 7.

 */

import java.util.HashMap;
import java.util.Scanner;

public class oppositeSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i] - rev(arr[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            res += (val * (val + 1) / 2);
        }
        System.out.print(res);
    }

    private static int rev(int n) {
        int r = 0;

        while (n != 0) {
            r *= 10;
            r += n % 10;
            n /= 10;
        }
        return r;
    }
}
