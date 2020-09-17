package 华为;

/*  统计大写字母的个数
    找出给定字符串中大写字符(即'A'-'Z')的个数

    输入描述:
    输入一个String数据

    输出描述:
    输出string中大写字母的个数

    示例1
    输入
    add123#$%#%#O
    输出
    1
 */

import java.util.Scanner;

public class 统计大写字母的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
