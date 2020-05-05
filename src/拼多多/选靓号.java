package 拼多多;

/*  选靓号
    A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。
    A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
    小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
    给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？

    输入描述：
    第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
    第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
    数据范围：
    2 <= K <= N <= 10000

    输出描述：
    第一行包含一个整数，表示修改成一个靓号，最少需要的金额。
    第二行包含 N 个数字字符，表示最少花费修改的新手机号。若有多个靓号花费都最少，则输出字典序最小的靓号。

    输入例子：
    6 5
    787585

    输出例子：
    4
    777577

    例子说明：
    花费为4的方案有两种：777577与777775，前者字典序更小。
 */

import java.util.Scanner;
/*  Greedy
    遍历 0-9 每一个数字，计算每一个数字出现k次时候的最小花费
    为了保证字典序最小，如果要变化的值小于当前值，则从前往后替代，如果大于当前值，则从后往前替代
 */
public class 选靓号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] nums = sc.next().toCharArray();
        greedyMinCost(N, K, nums);
    }

    private static void greedyMinCost(int N, int K, char[] nums) {  // 787585
        int min = Integer.MAX_VALUE;
        char[] res = new char[N];

        int[] repeat = new int[10];
        for (char num : nums) {
            repeat[num - '0']++;            // [0,0,0,0,2,0,2,2,0]
        }

        // 遍历 0-9 作为基准数字的可能
        for (int num = 0; num <= 9; num++) {
            int need = K - repeat[num];     // need = 5

            // corner case
            if (need <= 0) {
                System.out.println(0);
                System.out.println(nums);
                return;

            }

            int cost = 0;
            // 贪心体现在上下界从 1 开始初始化
            int upper = num + 1;        // upper = 1
            int lower = num - 1;        // lower = -1

            char[] temp = new char[N];
            System.arraycopy(nums, 0, temp, 0, N);

            while (need > 0) {
                // 如果手机号中的数字比最佳数字大，从前往后替换
                if (upper <= 9) {
                    for (int i = 0; i < N && need > 0; i++) {
                        if (nums[i] - '0' == upper) {
                            cost += upper - num;
                            temp[i] = (char) (num + '0');
                            need--;
                        }
                    }
                }
                // 如果手机号中的数字比最佳数字小，从后往前替换
                if (lower >= 0) {
                    for (int i = N - 1; i >= 0 && need > 0; i--) {
                        if (nums[i] - '0' == lower) {
                            cost += num - lower;
                            temp[i] = (char) (num + '0');
                            need--;
                        }
                    }
                }
                // 扩大上下限
                upper++;
                lower--;
            }
            if (cost < min) {
                min = cost;
                res = temp;
            }
        }
        System.out.println(min);
        System.out.println(res);
    }
}
