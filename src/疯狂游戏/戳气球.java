package 疯狂游戏;

/*  戳气球

 */

import java.util.Scanner;

public class 戳气球 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] in = input.split(",");
        int n = in.length;
        if (n == 0) {
            System.out.print(0);
            return;
        } else if (n == 1) {
            int res = Integer.parseInt(in[0]);
            System.out.print(res);
            return;
        } else if (n == 2) {
            int num = Math.max(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
            int res = num + (Integer.parseInt(in[0]) * Integer.parseInt(in[1]));
            System.out.print(res);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : in) {
            sb.append(s);
        }
        String s = sb.toString();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int local = 0;
            if (i == 0 && i + 1 < n) {
                local += (s.charAt(0) - '0') * (s.charAt(1) - '0');
            } else if (i == n - 1 && i - 1 >= 0) {
                local += (s.charAt(n - 1) - '0') * (s.charAt(n - 2) - '0');
            } else {
                // 3 + (158)
                local += (s.charAt(i - 1) - '0') * (s.charAt(i) - '0') * (s.charAt(i + 1) - '0');
            }
            local += helper(s.substring(0, i) + s.substring(i + 1));
            max = Math.max(max, local);
        }
        System.out.print(max);
    }

    private static int helper(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int local = 0;
            if (i == 0) {
                local += (s.charAt(0) - '0') * (s.charAt(1) - '0');
            } else if (i == n - 1) {
                local += (s.charAt(n - 1) - '0') * (s.charAt(n - 2) - '0');
            } else {
                // 3 + (158)
                local += (s.charAt(i - 1) - '0') * (s.charAt(i) - '0') * (s.charAt(i + 1) - '0');
            }
            local += helper(s.substring(0, i) + s.substring(i + 1));
            max = Math.max(max, local);
        }
        return max;
    }
}
