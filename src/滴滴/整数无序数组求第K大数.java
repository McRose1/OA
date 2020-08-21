package 滴滴;

/*  整数无序数组求第 K 大数
    给定无序整数序列，求其中第 K 大的数，例如 {45, 67, 44, 21}，第 2 大数为 45

    输入描述:
    输入第一行为整数序列，数字用空格分隔，如：45 67 33 21
    输入第二行一个整数K，K在数组长度范围内，如：2
    输出描述:
    输出第K大的数，本例为第2大数：45

    示例：
    输入：
    45 67 33 21
    2
    输出：
    45
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class 整数无序数组求第K大数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int K = sc.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }
        System.out.println(minHeap.poll());
    }
}
