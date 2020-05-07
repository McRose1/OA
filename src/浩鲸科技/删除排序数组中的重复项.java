package 浩鲸科技;

/*  删除排序数组中的重复项（LC 26）
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。

    输入描述：
    给定数组nums = [1,1,2],
    输入格式为[1,1,2]

    输出描述：
    函数应该返回新的长度2,并且原数组nums的前两个元素被修改为1, 2。
    你不需要考虑数组中超出新长度后面的元素。

    输入例子：
    [1,1,2]

    输出例子：
    2
 */

import java.util.Scanner;
//  Two Pointers
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.substring(1, s.length() - 1).split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++){
            if (nums[fast] != nums[slow]){
                slow++;
                // change the duplicate number to unique number
                nums[slow] = nums[fast];
            }
        }
        System.out.println(slow + 1);
    }
}
