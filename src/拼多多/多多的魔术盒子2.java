package 拼多多;

/*  LC 945
    Input:
    3
    1 2 2
    Output:
    1

    Input:
    6
    3 2 1 2 1 7
    Output:
    6
 */

import java.util.Scanner;

public class 多多的魔术盒子2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] box = new int[N];
        for (int i = 0; i < N; i++) {
            box[i] = sc.nextInt();
        }
        int[] counter = new int[40001];
        int max = -1;
        for (int num : box) {
            counter[num]++;
            max = Math.max(max, num);
        }

        int move = 0;
        for (int num = 0; num <= max; num++) {
            if ((counter[num] > 1)) {
                int d = counter[num] - 1;
                move += d;
                counter[num + 1] += d;
            }
        }
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        System.out.println(move);
    }
}

/*  TLE

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
 */