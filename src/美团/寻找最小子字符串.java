package 美团;

/*  寻找最小子字符串 LC 76
    小美和小团在玩一个游戏，小美任意给出一个大字符串 str1 以及一个独立的小字符串 str2，小团需要从这个大字符串 str1 里找到包含独立小字符串 str2
    中所有字符的最小子字符串 str；
    例如，小美给出一个大字符串“meituan2019”和一个子字符串“i2t”，那么小团给出的答案就应该是“ituan2”

    需要注意：
    1、str1 中有可能没有完整包含 str2 所有字符的情况，此时返回“”，即为空字符串；
    2、str1 不会为空，但 str2 有可能为空，此时返回整个 str1；
    3、str2 可能存在重复的字符，此时 str3 需要包含相同数量该字符；

    输入例子 1：
    "meituan2019","i2t"

    输出例子 1:
    "ituan2"
 */

import java.util.HashMap;
import java.util.Map;
//  Sliding Window 
public class 寻找最小子字符串 {
    public String getMinString(String str1, String str2) {
        if (str2 == null || str2.length() == 0) return str1;
        Map<Character, Integer> dictStr2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            dictStr2.put(ch, dictStr2.getOrDefault(ch, 0) + 1);
        }
        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for (int fast = 0; fast < str1.length(); fast++) {
            char c = str1.charAt(fast);
            Integer count = dictStr2.get(c);
            if (count == null) {
                continue;
            }
            dictStr2.put(c, count - 1);

            if (count == 1) {
                matchCount++;
            }

            while (matchCount == dictStr2.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftmost = str1.charAt(slow++);
                Integer leftmostCount = dictStr2.get(leftmost);
                if (leftmostCount == null) {
                    continue;
                }
                dictStr2.put(leftmost, leftmostCount + 1);
                if (leftmostCount == 0) {
                    matchCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : str1.substring(index, index + minLen);
    }
}
