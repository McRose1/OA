package 美团;

/*  最大矩形 LC 85
    给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

    输入描述：
    输入一个仅包含‘0’和‘1’的二维字符数组、
    第一行输入左大括号{，最后一行输入右大括号}。
    中间每行输入只包含‘0’和‘1’的字符数组（字符数组的长度不超过 20），字符使用单引号‘’，字符之间使用逗号，隔开，字符数组的开始和结束使用大括号{}。
    字符数组之间换行，并使用逗号，隔开。（字符数组的个数不超过 20）。

    输出描述：
    输出只包含字符‘1’的最大矩形的面积。

    输入例子 1：
    {
    {'1','0'},
    {'1','0'}
    }
    输出例子 1：
    2

    输入例子 2：
    {
    {'0','0'},
    {'0','1'}
    }
    输出例子 2：
    1
 */

import java.util.*;

public class 最大矩形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            if (sc.next() == "{") {
                continue;
            }
            if (sc.next() == "}") {
                break;
            }
            while (sc.hasNext()) {
                String s = new String();
                s = sc.next();
                System.out.println(s);
            }
        }
     }
}
