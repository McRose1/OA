package Shopee;

/*  Shopee 的零食柜（LC 410）
    小虾想跟着音乐的节奏来跑步，音乐有 7 种音符，对应的是 1 到 7，那么他对应的步长就可以是 1-7 分米，在规定的 m 分钟跑完。
    他需要规划他每分钟需要跑过的音符，下面是小虾同学听的歌曲的音符，以及规定的时间，你能告诉他每分钟他应该跑多少步长？

    输入描述：
    输入的第一个数字 n (1<=n<=1000000，表示音符数)，输入的第二个数字 m(1<=m<1000000，m<=n)，
    接着有 n 个数，表示每个音符（1<=f<=7）

    输出描述：
    输出每分钟应该跑的步长

    输入例子：
    8 5 6 5 6 7 6 6 3 1
    输出例子：
    11
 */

import java.util.Scanner;
/*  Binary Search
    题意就是给定有 n 个元素的数组，将该数组分成 m 个子数组，使得 m 个子数组每个数组和的最大值最小
    6 5 6 7 6 6 3 1
    [6,5], [6], [7], [6], [6], [3,1] -> 这样数组和的最大值为 6 + 5 = 11 是所有其他分法里最小的
 */
public class Shopee的零食柜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        // 最大的一步
        int max = -1;
        // 总步数
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int numOfSteps = split(nums, mid);
            if (numOfSteps > m) {
                // 花费时间大于m，应增大step
                left = mid + 1;
            } else if (numOfSteps < m) {
                // 花费时间小于m，应缩小step
                right = mid - 1;
            }
            else {
                // 花费时间相等，试着进一步缩小 step
                right = mid;
            }
        }
        System.out.println(left);
        sc.close();
    }

    // 每分钟走step步，若花费时间小于m分钟，返回-1，若相等，返回零，若大于，返回1
    private static int split(int[] nums, int validMaxStepLen) {
        int sum = 0;
        int steps = 1;
        for (int num : nums) {
            if (sum + num > validMaxStepLen) {
                sum = num;
                steps++;
            } else {
                sum += num;
            }
        }
        return steps;
    }
}
