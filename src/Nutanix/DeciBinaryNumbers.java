package Nutanix;

/*  Deci-Binary Numbers
    We call a number Deci-Binary if its decimal representation has only digits 0 or 1 or both.
    For example, numbers 0, 10, 101 - are Deci-Binary numbers, while 12, 25, 102 are not.
    You are given a positive integer n.
    Represent it as a sum of the minimum number of Deci-Binary numbers.

    Note: you need to find the lexicographically maximal of such sequence which sums to the given number.

    Example 1:
    Input: 4
    Output:
    4
    1 1 1 1

    Example 2:
    Input: 21
    Output:
    2
    10 11
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
    given number n, 将 the digit is non-zero 的位置替换成 1 就可以形成 m: 5102 -> 1101; 4001 -> 1001; 3000 -> 1000; 1 -> 1
 */
public class DeciBinaryNumbers {
    public List<Integer> psuedoBinary(int n) {
        List<Integer> res = new ArrayList<>();

        // Repeat below steps until n == 0
        while (n != 0) {                        // 21; 10

            // calculate m (A number that has same number of digits as n,
            // but has 1 in place of non-zero digits 0 in place of 0 digits)
            int temp = n, m = 0, p = 1;
            while (temp != 0) {                 // temp = 21; 2; 0 -> temp = 10; 1
                int rem = temp % 10;            // rem = 1; rem = 2 -> rem = 10 % 10 = 0; 1
                temp = temp / 10;               // temp = 2; 0 -> temp = 10 / 10 = 1; 0

                if (rem != 0) {                                             // rem == 0
                    m += p;                     // m = 0 + 1 = 1; 10 + 1 = 11 -> m = 0 + 10 = 10
                }
                p *= 10;                        // p = 10; 100      -> p = 10; 100
            }
            res.add(m);                         // [11]         -> [10]

            // subtract m from n
            n = n - m;                          // n = 21 - 11 = 10; n = 10 - 10 = 0
        }
        int count = res.size();
        System.out.println(count);
        Collections.sort(res);
        return res;                     // [10, 11]
    }
}
