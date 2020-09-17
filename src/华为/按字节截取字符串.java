package 华为;

/*  按字节截取字符串
    编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
    但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。

    输入描述:
    输入待截取的字符串及长度

    输出描述:
    截取后的字符串

    示例1
    输入
    我ABC汉DEF
    6
    输出
    我ABC
 */

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class 按字节截取字符串 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] str = new String[s.length()];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(s.charAt(i));
        }
        int len = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (String value : str) {
            int chLen = value.getBytes("GBK").length;
            if (len >= chLen) {
                len -= chLen;
                sb.append(value);
            } else {
                break;
            }
        }
        System.out.println(sb.toString());
    }
}
