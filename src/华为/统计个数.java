package 华为;

/*  统计个数
    输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。

    输入描述:
    输入一行字符串，可以有空格

    输出描述:
    统计其中英文字符，空格字符，数字字符，其他字符的个数

    示例1
    输入
    1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
    输出
    26
    3
    10
    12
 */

import java.util.Scanner;

public class 统计个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int letterCnt = 0;
        int spaceCnt = 0;
        int digitCnt = 0;
        int otherCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letterCnt++;
            } else if (c == ' ') {
                spaceCnt++;
            } else if (Character.isDigit(c)) {
                digitCnt++;
            } else {
                otherCnt++;
            }
        }
        System.out.println(letterCnt);
        System.out.println(spaceCnt);
        System.out.println(digitCnt);
        System.out.println(otherCnt);
    }
}
