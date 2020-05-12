package 字节跳动;

/*
    每天穿的两只袜子颜色一致，不分左右，事先对所有的袜子重新染色，染色的袜子个数尽可能少。

    输入：
    3 2
    1 2 3
    1 2
    2 3

    输出：
    2

    说明：
    把编号为 1 和 3 的袜子颜色改成 2，需要染色 2 次。
 */

import java.util.Scanner;
//  Union Find
public class 袜子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] socks = new int[n];
        for (int i = 0; i < n; i++) {
            socks[i] = sc.nextInt();
        }
        int count = 0;
        while (m-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            if (socks[left - 1] != socks[right - 1]) {
                socks[left - 1] = socks[right - 1];
                count++;
            }
        }
        System.out.println(count);
    }
}
