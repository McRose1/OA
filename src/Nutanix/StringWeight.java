package Nutanix;

/*  String Weight
    Given a binary string, you can transform it by toggling 1s to 0s and vice versa.
    You can make as many transformations as you want.
    Find out the maximum string weight you can get with given string as explained below:

    Given 3 numbers:
    Weight of a single pair = p
    Weight of a single character = s
    Weight of a single transformation = t

    Note:
    Weight of the transformed string = p + s - t.
    A character in a string can be counted only once - either for a pair or a single character.
    2 adjacent characters are a pair only if they are different, i.e. 00 and 11 don't form a pair but 01 and 10 do.

    Test cases:
    Input: p, s, t, string = 4, 2, 1, "110"
    Output: 6

    Input: p, s, t, string = 4, 1, 1, "00"
    Output: 3

    Input: p, s, t, string = 4, 1, 1, "011"
    Output: 5

    Input: p, s, t, string = 4, 1, 1, "0000011"
    Output: 11
 */

/*  DP
    两种情况：
    1. First character considered separately 相等和不相等都是 1 + getMaxRec(i + 1)
    2. First pair considered separately 相等: 4 + getMaxRec(i + 2) 不相等: 3 + getMaxRec(i + 2)
 */

public class StringWeight {
    public int getMaxWeight(String str) {           // "00"
        int n = str.length();                       // n = 2

        // Create and initialize lookup table
        int[] lookup = new int[n];
        for (int i = 0; i < n; i++) {
            lookup[i] = -1;                         // [-1, -1]
        }

        // Call recursive function
        return getMaxRec(str, 0, n, lookup);
    }

    private int getMaxRec(String str, int i, int n, int[] lookup) {
        // Base case
        if (i >= n) {                                                   // 2 >= 2
            return 0;
        }

        // If this subproblem is already solved
        if (lookup[i] != -1) {
            return lookup[i];
        }

        // Don't make pair, so weight gained is 1
        int ans = 1 + getMaxRec(str, i + 1, n, lookup);     // ans=1+getMaxRec(1) -> 2; ans=1+getMaxRec(2) -> 1

        // If we can make pair
        if (i + 1 < n) {                                        // 1+1=2; 0+1<2
            // If elements are dissimilar, weight gained is 4
            if (str.charAt(i) != str.charAt(i + 1)) {
                ans = Math.max(4 + getMaxRec(str, i + 2, n, lookup), ans);
            }

            // if elements are similar so far making a pair we toggle any of them.
            // Since toggle cost is 1 so overall weight gain becomes 3
            else {
                ans = Math.max(3 + getMaxRec(str, i + 2, n, lookup), ans);  // ans=max(3+getMaxRec(2), 2) = 3
            }
        }
        // save and return maximum of above cases.
        lookup[i] = ans;                    // lookup[1]=1; lookup[0]=3
        return ans;                         // return 1; return 3
    }
}
