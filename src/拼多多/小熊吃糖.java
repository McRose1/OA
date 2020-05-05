package 拼多多;

/*  小熊吃糖
    有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。
    前面的小熊吃饱了，后面的小熊才能吃。
    每只小熊有一个饥饿值，每次进食的时候，小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
    现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
    求所有小熊进食完之后，每只小熊剩余的饥饿值。

    输入描述：
    第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
    第二行m个正整数，每个表示着颗糖能填充的饥饿值。
    接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
    题目中所有输入的数值小于等于100。

    输出描述：
    输出n行，每行一个整数，代表每只小熊剩余的饥饿值。

    输入例子：
    2 5
    5 6 10 20 30
    4 34
    3 35

    输出例子：
    4
    0

    例子说明：
    第一只小熊吃了第5颗糖
    第二只小熊吃了第4颗糖
    第二只小熊吃了第3颗糖
    第二只小熊吃了第1颗糖
 */

import java.util.*;

public class 小熊吃糖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] candy = new int[m];
        for (int i = 0; i < m; i++) {
            candy[i] = sc.nextInt();
        }
        // 糖按可以填充饥饿值从小到大排序
        Arrays.sort(candy);

        // 利用 HashMap 来维护输入的顺序，便于最后的输出
        HashMap<Integer, Bear> map = new HashMap<>();
        Bear[] bear = new Bear[n];
        for (int i = 0; i < n; i++) {
            int attack = sc.nextInt();
            int hungry = sc.nextInt();
            bear[i] = new Bear(attack, hungry);
            map.put(i, bear[i]);
        }

        // 按战斗力从大到小排序
        Arrays.sort(bear, new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                return o2.attack - o1.attack;
            }
        });

        for (int i = 0; i < n; i++) {
            // 从填充饥饿值大的糖开始吃
            for (int j = m - 1; j >= 0; j--) {
                if (candy[j] != -1 && bear[i].hungry - candy[j] >= 0) {
                    bear[i].hungry -= candy[j];
                    // 吃完标记为-1，防止重复吃
                    candy[j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(map.get(i).hungry);
        }
    }

    public static class Bear {
        int attack;
        int hungry;

        public Bear(int attack, int hungry) {
            this.attack = attack;
            this.hungry = hungry;
        }
    }
}
