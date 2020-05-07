package 浩鲸科技;

/*  整数去重
    输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

    输入描述：
    输入一个int型整数

    输出描述：
    按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

    输入例子：
    9876673

    输出例子：
    37689
 */

import java.util.HashSet;
import java.util.Scanner;

public class 整数去重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!set.contains(s.charAt(i) - '0')) {
                sb.append(s.charAt(i));
                set.add(s.charAt(i) - '0');
            }
        }
        System.out.println(sb.toString());
    }
}
