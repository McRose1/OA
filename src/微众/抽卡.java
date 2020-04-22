package 微众;

/*
抽卡是一类类似于博弈的游戏。现在有一种抽卡方式，描述如下：

初始你只有一次抽卡机会。每次抽卡浪费一次抽卡机会，获得一张卡片。这张卡片上有两个数字，第一个数字代表你能获得的钱，第二个数字代表你能获得的额外抽卡次数。额外的抽卡次数是可以累计的。

现在，你知道了卡片的数量，所有的卡片上的数字，以及所有卡片的顺序。你只需要安排一种抽卡顺序，使得你能获得钱数最多。

输入
第一个行一个数n,代表卡片的数量。 接下来n行，每行用两个数ai,bi描述一张卡片。ai表示抽这张卡能获得的钱数，bi表示抽这张卡能获得的额外抽卡次数。

输出
一行一个数，代表你能获得的最多钱数。


样例输入
5
0 2
1 1
1 0
1 0
2 0
样例输出
4

提示
对于100%的数据，0≤a_i,b_i≤1000,1≤n≤1000
样例解释：按顺序抽第2,1,5,4张卡
 */

import java.util.Arrays;
import java.util.Scanner;

public class 抽卡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        int[] chance = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
            chance[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(money[0]);
        }
        int times = 0;
        for (int i = 0; i < n; i++) {
            times += chance[i];
        }
        Arrays.sort(money);
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (times == 0) {
                break;
            }
            sum += money[i];
            times--;
        }
        System.out.println(sum);
    }
}
