package Roblox;

/*  Ancestral Names

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AncestralNames {
    public void sortRoman(List<String[]> names) {
        names.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].compareTo(o2[0]) == 0) {
                    return romanToInt(o1[1]) - romanToInt(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
    }

    private static int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') res+= 1;
            if (s.charAt(i) == 'V') res+= 5;
            if (s.charAt(i) == 'X') res+= 10;
            if (s.charAt(i) == 'L') res+= 50;
            if (s.charAt(i) == 'C') res+= 100;
            if (s.charAt(i) == 'D') res+= 500;
            if (s.charAt(i) == 'M') res+= 1000;
        }
        // 6 subtraction
        if (s.contains("IV")) res-= 2;
        if (s.contains("IX")) res-= 2;
        if (s.contains("XL")) res-= 20;
        if (s.contains("XC")) res-= 20;
        if (s.contains("CD")) res-= 200;
        if (s.contains("CM")) res-= 200;

        return res;
    }
}
