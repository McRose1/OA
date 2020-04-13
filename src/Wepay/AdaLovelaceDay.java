package Wepay;

/*  Ada Lovelace Day
    Ada Lovelace Day, celebrating Ada, Countless of Lovelace as the first computer programmer,
    is traditionally celebrated on the second Tuesday of October each year.

    Write a function that takes a year in the Gregorian calendar as an integer and returns the day of October on which Ada Lovelace Day falls,
    also as an integer. For example, given 2018 you should return 9 (since the 9th of October is the second Tuesday in October of 2018).

    Your function does not have to account for non-gregorian calendars or null years.
    You may use, and refer to documentation on, calendar, data, and related libraries in the language of your choice for this question.
 */

import java.util.Calendar;

public class AdaLovelaceDay {
    public static void main(String[] args) {
        int year = 2018;
        int day = whichDay(year);
        System.out.println(day);
    }
    public static int whichDay(int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 1);
        int day = c.get(Calendar.DAY_OF_WEEK);
        if (day <= 3) {
            return 3 - day + 8;
        } else {
            return 7 - day + 11;
        }
    }
}
