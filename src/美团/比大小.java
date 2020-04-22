package 美团;

/*  比大小
    给定一个整数数组，返回一个数组。该返回数组中第i个数字为，原数组中第i个位置的数字至少往右走多少步才能遇到比它大的数字。
    如果遇不到或者已经处于最右的位置，则置为-1。

    输入描述：
    输入为多行，第一行为一个整数N，1≤N≤10^6
    接下来一共有N行，每一行为一个整数M，0≤M≤2^32-1

    输出描述：
    输出 N 行，每行一个数字表示转换之后的数组

    输入例子：
    5
    91
    10
    3
    22
    40

    输出例子：
    -1
    2
    1
    1
    -1
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//  Stack
public class 比大小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb.toString());
        /*
        反复调用会超时
        for (int num : res) {
            System.out.println(num);
        }
         */
    }
}

/*  Brute Force: TLE

        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int step = -1;
            while (j < n) {
                if (nums[j] > nums[i]) {
                    step = j - i;
                    System.out.println(step);
                    break;
                }
                j++;
            }
            if (step == -1) {
                System.out.println(-1);
            }
        }
        System.out.println(-1);
 */
