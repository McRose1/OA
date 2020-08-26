package Robinhood;

/*  oddOccurrencesOfZeros

    Input: a = [20, 11, 10, 10070, 7]
    Output: 3
 */

import java.util.Scanner;

public class oddOccurrencesOfZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        for (int num : a) {
            String s = "" + num;
            int zero = 0;

            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                }
            }

            if (zero % 2 == 1) {
                count++;
            }
        }
        System.out.print(count);
    }
}
