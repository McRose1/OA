package 华为;

/*  百钱买百鸡问题
    公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。
    百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？

    输入描述:
    输入任何一个整数，即可运行程序。

    输出描述:


    示例1
    输入
    1
    输出
    0 25 75
    4 18 78
    8 11 81
    12 4 84
 */

import java.util.Scanner;

/*  数学
    x + y + z = 100
    5x + 3y + 1/3z = 100
    =>
    7x + 4y = 100 (0 <= x <= 14) (0 <= y <= 25)
 */
public class 百钱买百鸡问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        for (int x = 0; x < 15; x++) {
            if ((100 - 7 * x) % 4 == 0) {
                int y = (100 - 7 * x) / 4;
                int z = 100 - x - y;
                System.out.println(x + " " + y + " " + z);
            }
        }
    }
}
