package 美团;

/*  寻找最后的山峰（LC 162 变形）从右往左遍历就哦了
    山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
    假设 nums[-1] = nums[n] = -∞。

    输入描述：
    在命令行中输入一行数字，数字之间以空格分割，遇到换行符结束。输入的数字为整型，且总数量在10万以内。

    输出描述：
    输出索引最大的山峰的索引值（一个数字）

    输入例子：
    2 4 1 2 7 8 4

    输出例子：
    5

    例子说明：
    索引最大的山峰的高度为8，其索引为5
 */

import java.util.Scanner;

public class 寻找最后的山峰 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int index = 0;
        int max = 0;

        if (nums.length == 1) {
            System.out.println(0);
            return;
        }

        if (nums.length == 2) {
            System.out.println(nums[0] > nums[1] ? 0 : 1);
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
