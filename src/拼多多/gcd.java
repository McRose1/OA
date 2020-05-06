package 拼多多;

import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = gcd(a, b);
        System.out.println(res);
    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a == b) {
            return a;
        }
        if (a < b) {
            gcd(b, a);
        }
        return gcd(b, a % b);
    }
}
