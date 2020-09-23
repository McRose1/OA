package 好未来;

/*  n个数里最小的k个
    找出n个数里最小的k个

    输入描述:
    每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
    不超过100。

    输出描述:
    输出n个整数里最小的k个数。升序输出

    输入例子1:
    3 9 6 8 -10 7 -11 19 30 12 23 5

    输出例子1:
    -11 -10 3 6 7
 */

import java.util.Arrays;
import java.util.Scanner;

public class n个数里最小的k个 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int[] nums = new int[str.length - 1];
        for (int i = 0; i < str.length - 1; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int k = Integer.parseInt(str[str.length - 1]);
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                System.out.println(nums[i]);
            } else {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
