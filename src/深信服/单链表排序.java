package 深信服;

/*  单链表排序
    请实现list_sort，使用冒泡法将head指向的链表按val值大小排成升序

    输入描述:
    第一行为数据个数 第二行为输入的数据，以空格进行分隔

    输出描述:
    输出head指向的链表数据，以空格分隔

    输入例子1:
    12
    10 22 2 5 9 8 1 33 4 6 7 9

    输出例子1:
    1 2 4 5 6 7 8 9 9 10 22 33
 */

import java.util.Arrays;
import java.util.Scanner;

public class 单链表排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
