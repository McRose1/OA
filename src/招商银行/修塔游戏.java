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

import java.util.Arrays;
import java.util.Scanner;
/*
    首先将塔分为三类：高度高于h的、低于h的、等于h的
    若高度等于h的塔有k座，则无需调整；否则，可以有两种调整方案：先低后高和先高后低
 */
public class 修塔游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               // n = 6
        int k = sc.nextInt();               // k = 5
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];                    // sum = 14
        }
        Arrays.sort(a);                 // [1,2,2,2,3,4]
        int min = Integer.MAX_VALUE;
        // 指针用来遍历
        int p = -1;
        // 记录下标 i 之前的所有数字之和
        int pre = 0;

        for (int i = 0; i < n; ) {
            p = i;                      // p=0; p=1
            while (p < n && a[p] == a[i]) { // a[0]=a[0]; a[3]=a[1]
                // 此时的 sum 表示后边和 a[i] 不相等数的加和
                sum -= a[i];                // sum = 14-1=13; sum=13-2;11-2;9-2=7
                // p 代表和 a[i] 相同的数字有多少个
                p++;                        // p=1; p=4
            }
            // 如果此时 a[i] 作为基准数，需要计算和目标k还差多少
            int need = Math.max(0, k - (p - i));      // need=5-1+0=4; max(0, 5-(4-1))=2
            // 初始数组就已经有k个相同的元素，直接输出
            if (need == 0) {
                min = 0;
                break;
            }
            // i 前面的数字升到 a[i] 就可以满足 target
            if (p >= k) {           // 1<5; 4<5
                min = Math.min(min, i * a[i] - pre - (i - need)); //
            }
            // i 后面的数字降到 a[i] 就可以满足 target
            if (n - i >= k) {       // 6-0=6>5; 6-1>=5
                // sum 表示后边和 a[i] 不相等数的加和，n-p 表示后边和 a[i] 不相等的数字的个数，
                int numAfterAi = n - p;
                int targetSum = numAfterAi * a[i];
                min = Math.min(min, sum - targetSum - (numAfterAi - need)); // 13-(6-1)*1-(6-1-4)=7; min(7, 7-(6-4)*2-(6-4-2))=3
            }
            pre += a[i] * (p - i);  // 1*(1-0)=1
            i = p;                  // i=1
        }
        System.out.println(min);
    }
}
