package 百度;

/*  李华的纪念品
    price，weight，心动值 v（1~5）
    在心动值不同的情况下，优先选择心动值大的纪念品；若心动值相同，优先选择比较便宜的纪念品
    最多能拿的物品重量为 m

    输入
    单组输入。

    第1行三个正整数，分别为：纪念品件数n，最多能拿的物品重量m，预算k。（n<1e5,m<100,k<10000,k的单位为元，m的重量为kg）

    第2行到第n+1行，分别为每件物品的价格price，重量weight，心动值v。（price<10000,weight<100,v为1~5之间的整数，price的单位为元，weight的重量为kg）

    输出
    在不超过预算并且保证不累的情况下，李华最多可以带回家的纪念品件数。

    输入：
    3 10 1000
    100 5 3
    50 3 2
    300 3 3

    输出：
    2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  82%

 */
public class 李华的纪念品 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<int[]> gift = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] temp = new int[3];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            temp[2] = sc.nextInt();
            gift.add(temp);
        }

        gift.sort((a, b) -> a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]);

        int count = 0;
        for (int[] cur : gift) {
            if (m >= cur[1] && k >= cur[0]) {
                count++;
                m -= cur[1];
                k -= cur[0];
            }
        }
        System.out.print(count);
    }
}
