package 字节跳动;

/*  找零
    Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为N(0<N<=1024)的商品，请问最少他会收到多少硬币？

    输入描述：
    一行，包含一个数N。

    输出描述：
    一行，包含一个数，表示最少收到的硬币数。

    输入例子：
    200

    输出例子：
    17

    例子说明：
    花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
 */

import java.util.Scanner;

public class 找零 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int diff = 1024 - N;
        int count = 0;
        if (diff > 64) {
            count += diff / 64;
            diff %= 64;
        }
        if (diff > 16) {
            count += diff / 16;
            diff %= 16;
        }
        if (diff > 4) {
            count += diff / 4;
            diff %= 4;
        }
        count += diff;
        System.out.println(count);
    }
}
