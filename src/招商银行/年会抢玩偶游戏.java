package 招商银行;

/*  年会抢玩偶游戏
    某公司年会上，组织人员安排了一个小游戏来调节气氛。游戏规则如下：
    N个人参与游戏，站成一排来抢工作人抛来的M个小玩偶。
    为了增加游戏的趣味和难度，规则规定，参与游戏的人抢到的礼物不能比左右两边的人多两个或以上，否则会受到一定的惩罚。游戏结束时拥有玩偶最多的人将获得一份大奖。
    假设大家都想赢得这份大奖，请问站在第K个位置的小招在赢得游戏时，最多能拥有几个玩偶？

    输入描述：
    输入为用空格分隔的3个正整数，依次为：参与游戏人数N、玩偶数M、小招所在位置K

    输出描述：
    输出为1个正整数，代表小招最多能够拥有的玩偶数。若没有，则输出0。

    输入例子 1：
    1 1 0
    输出例子 1：
    0

    输入例子 2：
    1 3 1
    输出例子 2：
    3
 */

import java.util.Scanner;

public class 年会抢玩偶游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        if (K < 1 || K > N) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[N + 1];
        while (M-- > 0) {
            nums[K]++;
            // 右边
            int k = K;
            // 当前位置比右边多两个或两个以上
            while (k + 1 <= N && nums[k + 1] + 1 < nums[k]) {
                nums[k]--;
                nums[k + 1]++;
                k++;
            }
            // 左边
            k = K;
            // 当前位置比左边多两个或两个以上
            while (k - 1 >= 1 && nums[k - 1] + 1 < nums[k]) {
                nums[k]--;
                nums[k - 1]++;
                k--;
            }
        }
        System.out.println(nums[K]);
    }
}
