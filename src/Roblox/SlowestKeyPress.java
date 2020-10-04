package Roblox;

/*  Slowest Key Press

 */

import java.util.List;

public class SlowestKeyPress {
    public static char slowestKey(List<List<Integer>> keyTimes) {
        int max = keyTimes.get(0).get(1);
        char res = (char) ('a' + keyTimes.get(0).get(0));
        int n = keyTimes.size();
        for (int i = 0; i < n - 1; i++) {
            List<Integer> next = keyTimes.get(i + 1);
            List<Integer> cur = keyTimes.get(i);
            int diff = next.get(1) - cur.get(1);
            if (diff > max) {
                max = diff;
                res = (char) (next.get(0) + 'a');
            }
        }
        return res;
    }
}
