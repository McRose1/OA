package 浩鲸科技;

/*  爱吃香蕉的珂珂
    珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
    珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
    如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
    珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

    提示：
    1 <= piles.length <= 10^4
    piles.length <= H <= 10^9
    1 <= piles[i] <= 10^9

    输入描述：
    输入:
    piles = [3,6,7,11], H = 8
    输入格式为:[3,6,7,11];8

    输出描述：
    输出: 4

    输入例子：
    [3,6,7,11];8

    输出例子：
    4
 */

import java.util.Scanner;
//  Binary Search
public class 爱吃香蕉的珂珂 {
    private static int[] piles;
    private static int H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int d = s.indexOf(';');
        String[] strs = s.substring(1, d - 1).split(",");
        piles = new int[strs.length];
        for (int i = 0; i < piles.length; i++) {
            piles[i] = Integer.parseInt(strs[i]);
        }
        H = Integer.parseInt(s.substring(d + 1));
        int low = 1, high = 1000000000, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (canfinish(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (canfinish(low)) {
            System.out.println(low);
        } else {
            System.out.println(low + 1);
        }
    }

    private static boolean canfinish(int k) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil(pile * 1.0 / k);
        }
        return sum <= H;
    }
}
