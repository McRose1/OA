package 招商银行;

/*
    小招正在玩一款修塔游戏：系统中有n座高塔，每座高塔由若干个高度相同的方块堆砌而成。修塔游戏的规则为：
   （1）每次从最高塔的塔尖拿走一个方块
   （2）每次在最低塔的塔尖堆砌一个方块
    小招每次只能完成上述两个动作中的一个动作。游戏的目标是使n座高塔中至少有k座高塔的高度相同，请问小招最少需要多少次才能完成游戏。

    输入描述:
    输入共有2行，第一行为n和k(1≤k≤n≤200000 )，第二行为n座塔的高度组成的数组 a1, a2, ...an(1≤aj≤10000)。

    输出描述:
    输出值为最少需要多少次动作才能完成游戏。

    示例1
    输入
    6 5
    1 2 2 4 2 3
    输出
    3
 */

import java.util.Scanner;

public class 修塔游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

    }
}
