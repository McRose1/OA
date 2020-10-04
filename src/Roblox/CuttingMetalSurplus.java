package Roblox;

/*  Cutting Metal Surplus

 */

import java.util.List;

public class CuttingMetalSurplus {
    public static int maxProfit(int costPerCut, int salesPrice, List<Integer> lens) {
        int res = 0;
        int max = 0;
        for (int l : lens) {
            max = Math.max(max, l);
        }
        for (int l = 1; l <= max; l++) {
            int cut = 0;
            int piece = 0;
            for (int len : lens) {
                int curCut = (len - 1) / l;
                int curPiece = len / l;
                if (l * salesPrice * curPiece - costPerCut * curCut > 0) {
                    cut += curCut;
                    piece += curPiece;
                }
            }
            res = Math.max(max, l * salesPrice * piece - costPerCut * cut);
        }
        return res;
    }
}
