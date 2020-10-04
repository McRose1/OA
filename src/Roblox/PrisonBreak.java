package Roblox;

/*  PrisonBreak

 */

import java.util.Arrays;

public class PrisonBreak {
    public int prison(int n, int m, int[] h, int[] v) {
        Arrays.sort(v);
        int count = 1;
        int maxV = 1;
        for (int i = 1; i < m; i++) {
            if (v[i] == v[i - 1] + 1) {
                count++;
                maxV = Math.max(maxV, count);
            } else {
                count = 1;
            }
        }
        maxV++;
        Arrays.sort(h);
        count = 1;
        int maxH = 1;
        for (int i = 1; i < n; i++) {
            if (v[i] == v[i - 1] + 1) {
                count++;
                maxV = Math.max(maxV, count);
            } else {
                count = 1;
            }
        }
        maxH++;

        return maxH * maxV;
    }
}
