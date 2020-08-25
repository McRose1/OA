package Robinhood;

/*  canMakeTriangle
    You are given an array of positive integers arr.
    You'd like to know how many triangles can be formed with side lengths equal to adjacent elements from arr.

    Construct an array of integers of length arr.length - 2, where ith element is equal to 1 if it's impossible to
    form a triangle with side lengths arr[i], arr[i + 1], and arr[i + 2], otherwise 0.

    Return the resulting array of integers.

    Note: A triangle can be formed with side lengths a, b, and c if a + b > c, a + c > b, and b + c > a.

    Example:
        o For arr = [1, 2, 2, 4], the output should be canMakeTriangle(arr) = [1, 0].
 */

import java.util.Scanner;

public class canMakeTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = new int[arr.length - 2];
        for (int i = 0; i < arr.length - 2; i++) {
            if (canMakeTriangle(arr[i], arr[i + 1], arr[i + 2])) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

    private static boolean canMakeTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
