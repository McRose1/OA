package 拼多多;

/*

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 多多的魔术盒子2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] box = new int[N];
        for (int i = 0; i < N; i++) {
            box[i] = sc.nextInt();
        }
        Arrays.sort(box);
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            while (set.contains(box[i])) {
                box[i]++;
                count++;
            }
            set.add(box[i]);
        }
        System.out.println(count);
    }
}
