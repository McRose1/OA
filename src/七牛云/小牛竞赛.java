package 七牛云;

import java.util.Scanner;

public class 小牛竞赛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] score = new int[n];
        int sum = 0;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            sum += score[i];
            preSum[i + 1] = sum;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    if (score[i] >= b) {
                        count++;
                    }
                } else {
                    int subSum = preSum[j + 1] - preSum[i];
                    if (subSum / (j - i + 1) >= b) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
