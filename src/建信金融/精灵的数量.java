package 建信金融;

/*
    城镇编号 A 和街道编号 B 之间的差异可被 3 整除
    街道号 B 和楼房门牌号 C 的总和可除以 5
    城镇号 A 和楼房门牌号 C 的乘积可被 4 整除
    城镇号 A 和公寓号 D 的最大公约数是 1

    输入：
    4 4 4 4

    输出：
    8
 */

import java.util.Scanner;

public class 精灵的数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int count = 0;
        for (int a = 1; a <= A; a++) {
            for (int b = 1; b <= B; b++) {
                for (int c = 1; c <= C; c++) {
                    for (int d = 1; d <= D; d++) {
                        if (Math.abs(a - b) % 3 == 0) {
                            if ((b + c) % 5 == 0) {
                                if ((a * c) % 4 == 0) {
                                    if (gcd(a, d) == 1) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            return gcd(b ,a);
        }
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
