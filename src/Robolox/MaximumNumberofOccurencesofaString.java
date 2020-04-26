package Robolox;

/*  LC 1297
    Given a string s, return the maximum number of occurrences of any substring under the following rules:
    The number of unique characters in the substring must be less than or equal to maxLetters.
    The substring size must be between minSize and maxSize inclusive.

    Example 1:
    Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
    Output: 2
    Explanation: Substring "aab" has 2 ocurrences in the original string.
    It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).

    Example 2:
    Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
    Output: 2
    Explanation: Substring "aaa" occur 2 times in the string. It can overlap.

    Example 3:
    Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
    Output: 3

    Example 4:
    Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
    Output: 0

    Constraints:
    1 <= s.length <= 10^5
    1 <= maxLetters <= 26
    1 <= minSize <= maxSize <= min(26, s.length)
    s only contains lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofOccurencesofaString {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        int n = s.length(), resCnt = 0;
        if(minSize > n) return 0;
        for(int i = 0; i < n; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int distNum = 0, j = 0; j < maxSize; j++){
                if(i + j >= n) break;
                map.put(s.charAt(i + j), map.getOrDefault(s.charAt(i + j), 0) + 1);
                if(map.get(s.charAt(i + j)) == 1) distNum++;
                if(distNum > maxLetters) break;
                if(j >= minSize - 1) {
                    String sub = s.substring(i, i + j + 1);
                    res.put(sub, res.getOrDefault(sub, 0) + 1);
                }
            }
        }
        for(String str: res.keySet()){
            if(res.get(str) > resCnt)
                resCnt = res.get(str);
        }
        return resCnt;
    }
}
