package 好未来;

/*  倒置字符串
    将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I

    输入描述:
    每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100

    输出描述:
    依次输出倒置之后的字符串,以空格分割

    输入例子1:
    I like beijing.

    输出例子1:
    beijing. like I
 */

import java.util.Scanner;

public class 倒置字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(str[i]);
            } else {
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
