package AkunaCapital;

/*  DivisibilityOfStrings
    As an assignment, a student is given two strings s and t. Create a function that performs per the following rules.
    1. Find whether strings s is divisible by string t. A string s divisible by string t if string t can be concatenated some number of times to obtain the string s.
        o If s is divisible, find the smallest string u such that it can be concatenated some number of times to obtain both s and t.
        o If it is not divisible, set the return value to -1.
    2. Finally, return the length of the string u or -1.A

    Example 1:
    s = "bcdbcdbcdbcd"
    t = "bcdbcd"

    If string t is concatenated twice, the result is "bcdbcdbcdbcd" which is equal to the string s. The string s is divisible by string t.
    Since it passes the first test, look for the smallest string u that can be concatenated to create both strings s and t.
    The string "bcd" is the smallest string that can be concatenated to create both strings s and t.
    The length of the string u is 3, the integer value to return.

    Example 2:
    s = "bcdbcdbcd"
    t = "bcdbcd"

    If string t is concatenated twice, the result is "bcdbcdbcdbcd" which is greater than string s.
    There is an extra "bcd" in the concatenated string.
    The string is not divisible by string t, so return -1.

    Function Description:
    Complete the function findSmallestDivisor in the editor below. The function should return a single integer denoting the length of the
    smallest string u if string s is divisible by string t, or return -1 if not.

    findSmallestDivisor has the following parameter(s):
        string s: a string
        string t: a string

    Constraints:
        o 1 <= size of s <= 2x10^5
        o 1 <= size if t <= 2x10^5
        o size of t <= size of s

    Input:
    lrbblrbb
    lrbb
    Output:
    4

    Input:
    rbrb
    rbrb
    Output:
    2
 */

import java.util.Scanner;

public class DivisibilityOfStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        int sLen = s.length();
        int tLen = t.length();

        // bcdbcdbcd - bcdbcd
        if (sLen % tLen != 0) {
            System.out.print(-1);
            return;
        }
        // bcdbcd - bca
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) != t.charAt(i % tLen)) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < tLen; i++) {
            int j = 0;
            int cycle = i + 1;
            for ( ; j < tLen; j++) {
                // bcd bcd
                if (t.charAt(j) != t.charAt(j % cycle)) {
                    break;
                }
            }
            if (j == tLen) {
                System.out.print(cycle);
                return;
            }
        }
        System.out.print(-1);
    }
}
