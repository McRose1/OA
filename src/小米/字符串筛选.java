package 小米;

/*  字符串筛选
    给定一个字符串, 需要去除所有之前曾经出现过的字符，只保留第一次出现的字符

    样例输入
    hello, welcome to xiaomi
    样例输出
    helo, wcmtxia
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 字符串筛选 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }
        System.out.println(sb.toString());
    }
}
