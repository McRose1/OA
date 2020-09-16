package 华为;

/*  计算日期到天数转换
    根据输入的日期，计算是这一年的第几天。。

    详细描述：

    输入某年某月某日，判断这一天是这一年的第几天？。

    测试用例有多组，注意循环输入

    输入描述:
    输入多行，每行空格分割，分别是年，月，日

    输出描述:
    成功:返回outDay输出计算后的第几天;
    失败:返回-1

    示例1
    输入
    2012 12 31
    输出
    366
 */

import java.util.Calendar;
import java.util.Scanner;

public class 计算日期到天数转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int date = sc.nextInt();
        if (year <= 0 || month <= 0 || month >= 13 || date <= 0 || date > 31) {
            System.out.println(-1);
        } else {
            Calendar c = Calendar.getInstance();
            c.set(year, month - 1, date);
            int res = c.get(Calendar.DAY_OF_YEAR);
            System.out.println(res);
        }
    }
}
