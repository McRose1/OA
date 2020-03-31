package 美团;

/*  无重复字符的最长子串 LC 3
    给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

    输入描述：
    一行一行字符串，长度不超过 1000
    输出描述：
    输出一个数字表示最长子串的长度

    输入例子 1：
    abcabcbb
    输出例子 1：
    3
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//  Sliding Window
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int len = s.length();
            int ans = 0;
            //  Unique character's recent index
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < len; j++) {
                if (map.containsKey(s.charAt(j))) {
                    // [i, j) always maintain the unique character substring
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            System.out.println(ans);
        }
    }
}
