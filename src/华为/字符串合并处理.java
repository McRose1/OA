package 华为;

/*  字符串合并处理

    按照指定规则对输入的字符串进行处理。

    详细描述：

    将输入的两个字符串合并。

    对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
    这里的下标意思是字符在字符串中的位置。

    对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
    则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
    如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
    如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。

    举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”

    输入描述:
    输入两个字符串

    输出描述:
    输出转化后的结果

    示例1
    输入
    dec fab
    输出
    5D37BF
 */

import java.util.Arrays;
import java.util.Scanner;

public class 字符串合并处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        String ss = str[0] + str[1];
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for (int i = 0; i < ss.length(); i++) {
            if (i % 2 == 0) {
                even.append(ss.charAt(i));
            } else {
                odd.append(ss.charAt(i));
            }
        }
        char[] oddArr = odd.toString().toCharArray();
        Arrays.sort(oddArr);
        char[] evenArr = even.toString().toCharArray();
        Arrays.sort(evenArr);
        StringBuilder original = new StringBuilder();
        int idx = 0;
        while (idx < evenArr.length && idx < oddArr.length) {
            original.append(evenArr[idx]);
            original.append(oddArr[idx]);
            idx++;
        }
        if (idx < evenArr.length) {
            original.append(evenArr[idx]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                sb.append(transform(c));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    private static Character transform(Character c) {
        int num;
        if (c == 'a' || c == 'A') {
            num = 10;
        } else if (c == 'b' || c == 'B') {
            num = 11;
        } else if (c == 'c' || c == 'C') {
            num = 12;
        } else if (c == 'd' || c == 'D') {
            num = 13;
        } else if (c == 'e' || c == 'E') {
            num = 14;
        } else if (c == 'f' || c == 'F') {
            num = 15;
        } else {
            num = c - '0';
        }
        String rev = binaryStringRev(num);
        int decimal = Integer.parseInt(rev, 2);
        String s = Integer.toString(decimal, 16);
        return Character.toUpperCase(s.charAt(0));
    }

    private static String binaryStringRev(int n) {
        StringBuilder sb = new StringBuilder();
        int flag = 1 << 3;
        for (int i = 0; i < 4; i++) {
            int val = (flag & n) == 0 ? 0 : 1;
            sb.append(val);
            n <<= 1;
        }
        return sb.reverse().toString();
    }
}
