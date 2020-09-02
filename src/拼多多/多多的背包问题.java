package 拼多多;

/*  多多的背包问题

    对于前 60% 的数据，商品占用的背包空间和商品的收益均为非负整数！

    示例：
    输入：
    4 4
    -1 -1
    1 -1
    -1 1
    6 6
    输出：
    6
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  24%

 */
public class 多多的背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            list.add(temp);
        }
        list.sort((a, b) -> b[1] - a[1]);

        int max = 0;
        for (int[] ints : list) {
            if (ints[0] < M) {
                max += ints[1];
                M -= ints[0];
            }
        }
        System.out.print(max);
    }
}
