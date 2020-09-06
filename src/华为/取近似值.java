package 华为;

/*  取近似值
    写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

    输入描述:
    输入一个正浮点数值

    输出描述:
    输出该数值的近似整数值

    示例1
    输入
    5.5
    输出
    6
 */

import java.util.Scanner;

public class 取近似值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("\\.");
        if (str[1].charAt(0) - '0' >= 5) {
            System.out.print(Integer.parseInt(str[0]) + 1);
        } else {
            System.out.print(Integer.parseInt(str[0]));
        }
    }
}
