package Robinhood;

/*
    给一个整数 n，判断 0 到 n 之间的数字里含有多少个 0，2，4

    Input: 22
    Output: 11
 */

import java.util.Scanner;

public class check024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            String cur = "" + i;
            if (cur.contains("0") || cur.contains("2") || cur.contains("4")) {
                for (char c : cur.toCharArray()) {
                    if (c == '0' || c == '2' || c == '4') {
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
