package Roblox;

/*  Competitive Gaming

 */

import java.util.Arrays;
import java.util.Comparator;

public class CompetitiveGaming {
    public int numPlayers(int k, Integer[] scores) {
        Arrays.sort(scores, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 1;
        int level = 1;
        int pre = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] == 0) {
                break;
            }
            if (scores[i] != pre) {
                pre = scores[i];
                level = i + 1;
            }
            if (level <= k) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
