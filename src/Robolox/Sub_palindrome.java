package Robolox;

/*  LC 647（变形）重复的子串记为 1 次
    Given a string s, how many distinct substrings of s are palindromes?

    For example, s = mokkori. Some of its substrings are [m,o,k,r,o,mo,ok,mok,okk,kk,okko].
    Each of the red elements is a palindromic substring of s.
    In total, there are 7 distinct palindromes.

    return the number of distinct palindromes as an integer.
 */

import java.util.HashMap;
import java.util.Map;

public class Sub_palindrome {
    public static int countDistinctSub(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        Map<String, Integer> map = new HashMap();

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    String sub = s.substring(i, j);
                    if (dp[i][j] && (!map.containsKey(sub) || map.get(sub) == 0)) {
                        count++;
                    } else {
                        map.put(sub, map.getOrDefault(sub, 0) + 1);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        int res = countDistinctSub(s);
        System.out.println(res);
    }
}
