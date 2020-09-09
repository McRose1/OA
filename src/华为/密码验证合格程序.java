package 华为;

/*  密码验证合格程序
    密码要求:

    1.长度超过8位

    2.包括大小写字母.数字.其它符号,以上四种至少三种

    3.不能有相同长度大于2的子串重复

    输入描述:
    一组或多组长度超过2的子符串。每组占一行

    输出描述:
    如果符合要求输出：OK，否则输出NG

    示例1
    输入
    021Abc9000
    021Abc9Abc1
    021ABC9000
    021$bc9000
    输出
    OK
    NG
    NG
    OK
 */

import java.util.Scanner;

public class 密码验证合格程序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String pwd = sc.nextLine();
            if (pwd.length() < 9) {
                System.out.println("NG");
                continue;
            }
            boolean digit = false;
            boolean upperLetter = false;
            boolean lowerLetter = false;
            boolean special = false;

            for (int i = 0; i < pwd.length(); i++) {
                char c = pwd.charAt(i);
                if (Character.isDigit(c)) {
                    digit = true;
                } else if (Character.isUpperCase(c)) {
                    upperLetter = true;
                } else if (Character.isLowerCase(c)) {
                    lowerLetter = true;
                } else {
                    special = true;
                }
            }
            int count = 0;
            if (digit) {
                count++;
            }
            if (upperLetter) {
                count++;
            }
            if (lowerLetter) {
                count++;
            }
            if (special) {
                count++;
            }
            if (count < 3) {
                System.out.println("NG");
            } else {
                if (checkSub(pwd)) {
                    System.out.println("OK");
                } else {
                    System.out.println("NG");
                }
            }
        }
    }

    private static boolean checkSub(String s) {
        int n = s.length();
        for (int i = 0; i < n - 2; i++) {
            String sub = s.substring(i, i + 3);
            if (s.substring(i + 1).contains(sub)) {
                return false;
            }
        }
        return true;
    }
}
