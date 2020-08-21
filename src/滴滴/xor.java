package 滴滴;

/*  xor
    给出 n 个数字 a_1,...a_n，问最多有多少不重叠的非空区间，使得每个区间内的 xor 都等于 0。

    输入描述:
    第一行一个整数ｎ； 第二行ｎ个整数　a_1,...,a_n； 对于30%的数据，n<=20； 对于100%的数据，n<=100000, a_i<=100000；
    输出描述:
    一个整数表示最多的区间个数；

    示例：
    输入：
    4
    3 0 2 2
    输出：
    2
 */

import java.util.Scanner;

/*  Greedy

 */
public class xor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int start = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j >= start; j--) {
                temp ^= nums[j];
                if (temp == 0) {
                    count++;
                    start = i + 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
