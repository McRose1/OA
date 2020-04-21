package 四三九九;

/*
    小陆每天要写一份工作日报，日报标题含有日期。几年后，他翻开以前的日报，想知道两份日报的日期是否同为星期几，请编程帮助他判断。

    输入描述：
    第一行一个正整数T(1<=T<=100)。表示有T个测试样例。
    接下来T行，每一行有6个正整数y1,m1,d1,y2,m2,d2,（以空格相间）。其中y1-m1-d1分别为第一个日期的年月日，y2-m2-d2分别为第二个日期的年月日。
    （满足1970<=y1,y2<=9999, 1<=m1,m2<=12, 1<=d1,d2<=31,且保证两个日期是合法的）。

    输出描述：
    输出T行，对应T个答案。对于每一行，如果两个日期在同一周，输出“True”；否则输出“False”（输出内容不含双引号）。

    输入例子：
    2
    1970 1 2 2020 2 7
    2020 1 1 2020 1 2

    输出例子:
    True
    False

    例子说明:
    1970-1-2和2020-2-7同为星期五；
    2020-1-1为星期三，2020-1-2为星期四。
 */

import java.util.Calendar;
import java.util.Scanner;

public class 日历问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int year1 = sc.nextInt();
            int month1 = sc.nextInt();
            int date1 = sc.nextInt();
            int year2 = sc.nextInt();
            int month2 = sc.nextInt();
            int date2 = sc.nextInt();

            Calendar c1 = Calendar.getInstance();
            c1.set(Calendar.YEAR, year1);
            c1.set(Calendar.MONTH, month1 - 1);
            c1.set(Calendar.DATE, date1);
            int week1 = c1.get(Calendar.DAY_OF_WEEK);

            Calendar c2 = Calendar.getInstance();
            c2.set(Calendar.YEAR, year2);
            c2.set(Calendar.MONTH, month2 - 1);
            c2.set(Calendar.DATE, date2);
            int week2 = c2.get(Calendar.DAY_OF_WEEK);

            if (week1 == week2) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
