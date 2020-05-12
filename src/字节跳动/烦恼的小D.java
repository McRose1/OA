package 字节跳动;

/*  LC 140
    被取掉了分隔符的英文文章和一本字典（小写字母），求出有多少种可以翻译的方法。
    输出对 835672545 的余数
    无法翻译，输出 0

    输入：
    abcba
    5
    ab
    cb
    bc
    ba
    a

    输出：
    2

    说明：
    ab | cb | a
    a | bc | ba
 */

import java.util.*;

public class 烦恼的小D {
    private static HashMap<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String article = sc.nextLine();         // abcba
        int N = Integer.parseInt(sc.nextLine());
        HashSet<String> wordDict = new HashSet<>();
        while (N-- > 0) {
            wordDict.add(sc.nextLine());    // [ab, cb, bc, ba, a]
        }
        List<String> ans;
        ans = dfs(article, wordDict, 0);
        for (String s : ans) {
            System.out.println(s);
        }
        System.out.println(ans.size());
    }

    private static List<String> dfs(String s, HashSet<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {   // a
                List<String> list = dfs(s, wordDict, end);      // list=dfs(s,wordDict,1)
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : "|") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
