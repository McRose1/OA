package 华为;

/*  删除字符串中出现次数最少的字符
    实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
    注意每个输入文件有多组输入，即多个字符串用回车隔开

    输入描述:
    字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。

    输出描述:
    删除字符串中出现次数最少的字符后的字符串。

    示例1
    输入
    abcdd
    输出
    dd
 */

import java.util.Scanner;

public class 删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] < min) {
                min = count[i];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] != min) {
                System.out.print(c);
            }
        }
    }
}
