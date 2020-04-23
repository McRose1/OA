package 美团;

/*  月份天数
    输入年份月份，请输出这个月的天数

    输入描述：
    多组输入输出
    第一个参数为年份，如2018代表2018年，2019代表2019年
    第二个参数为月份，如1代表1月，2代表2月
    （参数间均以空格隔开）

    输出描述：
    输出当月的实际天数。

    输入例子：
    2018 2
    2020 2
    2019 1

    输出例子：
    28
    29
    31
 */

import java.util.Calendar;
import java.util.Scanner;

public class 月份天数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);

            Calendar c = Calendar.getInstance();
            // 将日历里的日设为0，日历就会倒转到上一个月的最后一天
            c.set(year, month, 0);
            int day_of_month = c.get(Calendar.DAY_OF_MONTH);
            System.out.println(day_of_month);
        }
    }
}
