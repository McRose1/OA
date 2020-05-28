package 学而思;

/*  LC 3
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    输入
    "abcabcbb"
    输出
    3

    样例输入
    abcabcbb
    样例输出
    3
 */

import java.util.HashSet;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstr(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 1;
        int left = 0;
        int right = 1;
        if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
