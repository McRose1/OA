package 拼多多;

/*  LC 473
    Input:
    2
    8
    1 1 1 1 2 2 4 4
    4
    1 1 1 2
    Output:
    YESprivate int target;
    NO
 */

import java.util.Arrays;
import java.util.Scanner;

public class 多多的团建活动2 {
    private static int target;

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
            if (sum % 4 != 0) {
                System.out.println("NO");
                return;
            }
            target = sum / 4;
            Arrays.sort(stick);
            if (dfs(stick, 0, 0, 1, new boolean[N])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int[] stick, int index, int tmp, int group, boolean[] visited) {
        if (group == 4) return true;

        if (tmp > target) return false;

        if (tmp == target) {
            return dfs(stick, 0, 0, group + 1, visited);
        }

        for (int i = index; i < stick.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && stick[i] == stick[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            if (dfs(stick, index + 1, tmp + stick[i], group, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
