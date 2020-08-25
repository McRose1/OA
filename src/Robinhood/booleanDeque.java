package Robinhood;

/*  booleanDeque
    You are given n, an integer representing the length of a binary string a, which is all '0's in the beginning.

    You are also given operations, an array of strings, each representing an operation of one of these two types:
        o "L" - find the smallest index i, for which a[i] = '0', and set a[i] = '1'. If there is no such index, do nothing.
        o "c{ind}" - set a[ind] = '0'. This operation does not depend on the previous value of a[ind].
           It is guaranteed that ind is a valid 0-based index of a (ie: ind < n).
    Given n and operations, your task is to return a, the binary string after all operations have been applied.

    Example:
        o For n = 10 and operations = ["L", "L", "C0", "L", "C3"], the output should be booleanDeque(n, operations) = "1100000000".
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class booleanDeque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] operations = sc.nextLine().split(" ");

        char[] a = new char[n];
        Arrays.fill(a, '0');
        TreeSet<Integer> zero = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            zero.add(i);
        }

        for (String op : operations) {
            if (op.charAt(0) == 'L') {
                if (!zero.isEmpty()) {
                    int idx = zero.first();
                    a[idx] = '1';
                    zero.pollFirst();
                }
            } else {
                int idx = Integer.parseInt(op.substring(1));
                a[idx] = '0';
                zero.add(idx);
            }
        }
        System.out.println(new String(a));
    }
}
