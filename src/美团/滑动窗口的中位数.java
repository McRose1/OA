package 美团;

/*  滑动窗口的中位数（LC 480）
    在实时计算中，数据流源源不断地流入计算单位，经常需要借助窗口来处理数据，其中有一类窗口为滑动窗口（Sliding Window），其特点是窗口长度固定，每次滑动一定的位移（slide）
    现给定一个数组 nums，有一个长度为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。注意你只可以看到滑动窗口 k 内的数字，
    滑动位移大小 slide = 1，即滑动窗口每次只向右移动一位。要求返回每一个滑动窗口内的中位数。
    注意：为了简化窗口计算，规定如果没有累计到窗口大小的数，不能触发计算，即不输出结果！

    输入描述：
    输入两个数字n，k。n表示数组长度，k表示窗口大小
    加下来n个整数用空格隔开，表示nums数组
    (1<=k<=n)
    (1<=n<=1000)

    输出描述：
    输出若干个数字，表示滑窗依次移动得到的结果，保留小数点后一位数字

    输入例子：
    8 3
    1 3 -1 -3 5 3 6 7

    输出例子：
    1.0 -1.0 -1.0 3.0 5.0 6.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class 滑动窗口的中位数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        for (int i = k; i <= nums.length; i++) {
            res[i - k] = ((double) window[k / 2] + window[(k - 1) / 2]) / 2;
            if (i == nums.length) break;
            remove(window, nums[i - k]);
            insert(window, nums[i]);
        }
        for (double num : res) {
            System.out.print(num + " ");
        }
    }
    // Insert val into window, window[k - 1] is empty before insertion
    private static void insert(int[] window, int val) {
        int i = 0;
        while (i < window.length - 1 && val > window[i]) {
            i++;
        }
        int j = window.length - 1;
        while (j > i) {
            window[j] = window[--j];
        }
        window[j] = val;
    }
    // Remove val from window and shrink it
    private static void remove(int[] window, int val) {
        int i = 0;
        while (i < window.length && val != window[i]) {
            i++;
        }
        while (i < window.length - 1) {
            window[i] = window[++i];
        }
    }
}
