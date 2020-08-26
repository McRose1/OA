package Robinhood;

/*  maxArithmeticLength
    Suppose we have array a and b (no duplicates & sorted).
    a = [0, 4, 8, 20]
    b = [5, 7, 12, 16, 22]
    Suppose you can pick any number of element from b (could be 0), and you want to insert them into array a
    such that all elements in a are increasing by certain number, so in this example you can pick "12, 16"
    from b and append into a such that a = [0, 4, 8, 12, 16, 20], which increase by 4 for each element.

    Write a function to return the maximum number of element in a after appending elements from b
    (in the example above the result is 6), if there is no such case, return -1.
 */

import java.util.HashSet;
import java.util.Scanner;

public class maxArithmeticLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        HashSet<Integer> diffs = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();
        for (int num : b) {
            bSet.add(num);
        }
        diffs.add(a[1] - a[0]);
        for (int num : b) {
            if (num - a[0] > 0) {
                diffs.add(num - a[0]);
            }
        }
        int max = -1;
        for (int diff : diffs) {
            int idx = 0;
            int cur = a[0];
            int res = 0;
            int c = a[0];
            while (bSet.contains(c - diff)) {
                c -= diff;
                res++;
            }
            while (idx < a.length) {
                if (bSet.contains(cur + diff)) {
                    cur += diff;
                } else if (idx < a.length - 1 && cur + diff == a[idx + 1]) {
                    cur = a[++idx];
                    continue;
                } else {
                    break;
                }
                res++;
            }
            if (idx == a.length - 1) {
                max = Math.max(max, res + (int) a.length);
            }
        }
        System.out.print(max);
    }
}
