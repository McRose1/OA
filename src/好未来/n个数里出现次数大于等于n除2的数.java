package 好未来;

/*  n个数里出现次数大于等于n除2的数
    输入n个整数，输出出现次数大于等于数组长度一半的数。

    输入描述:
    每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。

    输出描述:
    输出出现次数大于等于n/2的数。

    输入例子1:
    3 9 3 2 5 6 7 3 2 3 3 3

    输出例子1:
    3
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n个数里出现次数大于等于n除2的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int half = nums.length / 2;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.containsKey(num)) {
                int cnt = count.get(num);
                if (cnt + 1 >= half) {
                    System.out.println(num);
                    return;
                } else {
                    count.put(num, cnt + 1);
                }
            } else {
                count.put(num, 1);
            }
        }
    }
}
