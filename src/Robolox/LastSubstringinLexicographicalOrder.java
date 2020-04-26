package Robolox;

/*  LC 1163
    Given a string s, return the last substring of s in lexicographical order.

    Example 1:
    Input: "abab"
    Output: "bab"
    Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"].
    The lexicographically maximum substring is "bab".

    Example 2:
    Input: "leetcode"
    Output: "tcode"

    Note:
    1 <= s.length <= 4 * 10^5
    s contains only lowercase English letters.
 */

//  Two Pointers
public class LastSubstringinLexicographicalOrder {
    public String lastSubstring(String s) {
        int i = 0, j = 1;
        int offset= 0;
        int len = s.length();

        while (i + offset < len && j + offset < len) {
            char c1 = s.charAt(i + offset);
            char c2 = s.charAt(j + offset);
            if (c1 == c2) {
                offset++;
            } else {
                if (c1 < c2) {
                    i += offset + 1;
                } else {
                    j += offset + 1;
                }
                if (i == j) {
                    i++;
                }
                offset = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}
