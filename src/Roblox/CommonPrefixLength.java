package Roblox;

/*  Common Prefix Length

 */

import java.util.ArrayList;
import java.util.List;

public class CommonPrefixLength {
    public static List<Integer> commonPrefix(List<String> inputs) {
        int n = inputs.size();
        List<Integer> res = new ArrayList<>();
        for (String input : inputs) {
            int cur = sum(input);
            res.add(cur);
        }
        return res;
    }

    private static int sum(String s) {
        int n = s.length();
        int res = n;
        for (int l = n - 1; l > 0; l--) {
            int cur = 0;
            for (int i = 0; i < l; i++) {
                if (s.charAt(i) == s.charAt(n - l + i)) {
                    cur++;
                } else {
                    break;
                }
            }
            res += cur;
        }
        return res;
    }
}
