package 拼多多;

import java.util.Scanner;

public class 多多的团建活动2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] stick = new int[N];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                stick[j] = sc.nextInt();
                sum += stick[j];
            }
            if (sum % N == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
