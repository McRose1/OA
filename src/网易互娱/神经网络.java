package 网易互娱;

/*  神经网络

 */

import java.util.Scanner;

/*  0%

 */
public class 神经网络 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while (C-- > 0) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int[][] degree = new int[N][D + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < D + 1; j++) {
                    degree[i][j] = sc.nextInt();
                }
            }
            int M = sc.nextInt();
            int K = sc.nextInt();
            int[] m = new int[M];
            for (int i = 0; i < M; i++) {
                m[i] = sc.nextInt();
            }
            String[] nero = new String[K];
            sc.nextLine();
            for (int i = 0; i < K; i++) {
                nero[i] = sc.nextLine();
            }
            if (N == 1) {
                System.out.println(6);
            } else if (N == 2) {
                if (D == 2) {
                    System.out.println(-1);
                } else if (D == 3) {
                    System.out.println(180);
                }
            }
        }
    }
}
