package 华为;

/*  字符串加解密
    1、对输入的字符串进行加解密，并输出。

    2加密方法为：

    当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

    当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

    其他字符不做变化。

    3、解密方法为加密的逆过程。

    接口描述：

        实现接口，每个接口实现1个基本操作：

    void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出

    说明：

    1、字符串以\0结尾。

    2、字符串最长100个字符。

    int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出

    说明：

    1、字符串以\0结尾。

    2、字符串最长100个字符。

    输入描述:
    输入说明
    输入一串要加密的密码
    输入一串加过密的密码

    输出描述:
    输出说明
    输出加密后的字符
    输出解密后的字符

    示例1
    输入
    abcdefg
    BCDEFGH
    输出
    BCDEFGH
    abcdefg
 */

import java.util.Scanner;

public class 字符串加解密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String before = sc.nextLine();
        String after = sc.nextLine();

        StringBuilder sbAfter = new StringBuilder();
        for (int i = 0; i < before.length(); i++) {
            char c = before.charAt(i);
            if (Character.isUpperCase(c)) {
                if (c == 'Z') {
                    sbAfter.append('a');
                } else {
                    sbAfter.append((char) (c + 33));
                }
            } else if (Character.isLowerCase(c)) {
                if (c == 'z') {
                    sbAfter.append('A');
                } else {
                    sbAfter.append((char) (c - 31));
                }
            } else if (Character.isDigit(c)) {
                if (c == '9') {
                    sbAfter.append('0');
                } else {
                    sbAfter.append((char) (c + 1));
                }
            } else {
                sbAfter.append(c);
            }
        }
        System.out.println(sbAfter.toString());

        StringBuilder sbBefore = new StringBuilder();
        for (int i = 0; i < after.length(); i++) {
            char c = after.charAt(i);
            if (Character.isUpperCase(c)) {
                if (c == 'A') {
                    sbBefore.append('z');
                } else {
                    sbBefore.append((char) (c + 31));
                }
            } else if (Character.isLowerCase(c)) {
                if (c == 'a') {
                    sbBefore.append('Z');
                } else {
                    sbBefore.append((char) (c - 33));
                }
            } else if (Character.isDigit(c)) {
                if (c == '0') {
                    sbBefore.append('9');
                } else {
                    sbBefore.append((char) (c - 1));
                }
            } else {
                sbBefore.append(c);
            }
        }
        System.out.println(sbBefore.toString());
    }
}
