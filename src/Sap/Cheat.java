package Sap;

import java.util.Scanner;

public class Cheat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] seats = new char[row][col];
        for (int i = 0; i < row; i++) {
            String temp = sc.next();
            for (int j = 0; j < col; j++) {
                seats[i][j] = temp.charAt(j);
            }
        }

        int[][] dp = new int[row + 1][1 << col];
        for (int i = row - 1; i >= 0; i--) {
            for (int preMask = 0; preMask < (1 << col); preMask++) {
                int res = 0;
                for (int curMask = 0; curMask < (1 << col); curMask++) {
                    if (isValid(curMask, preMask, seats, i)) {
                        res = Math.max(res, Integer.bitCount(curMask) + dp[i + 1][curMask]);
                    }
                }
                dp[i][preMask] = res;
            }
        }
        System.out.println(dp[0][0]);
    }

    static private boolean isValid(int mask, int preMask, char[][] seats, int r) {
        int m = seats[0].length;
        for (int i = 0; i < m; i++) {
            if ((mask & (1 << i)) == 0) {
                continue;
            }
            if (seats[r][i] == '+') {
                return false;
            }
            // 4 个方向
            if (i > 0 && seats[r][i - 1] == '.' && (mask & (1 << (i - 1))) != 0) {
                return false;
            }
            if (i < m - 1 && seats[r][i + 1] == '.' && (mask & (1 << (i + 1))) != 0) {
                return false;
            }
            if (r > 0 && i > 0 && seats[r - 1][i - 1] == '.' && (preMask & (1 << (i - 1))) != 0) {
                return false;
            }
            if (r > 0 && i < m - 1 && seats[r - 1][i + 1] == '.' && (preMask & (1 << (i + 1))) != 0) {
                return false;
            }
        }
        return true;
    }
}
