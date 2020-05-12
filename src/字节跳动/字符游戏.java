package 字节跳动;

/*
    小写字母组成的字符串 s，每次指定 l-r 的范围，统计 l->r 有多少个不同的字符。
    可以修改字符串中的某一位 pos 改为其他小写字母 c，s[pos] = c

    输入：
    abacaba
    5
    2 1 4
    1 4 b
    1 5 b
    2 4 6
    2 1 7

    输出：
    3
    1
    2

    说明：
    abac -> 3
    abababa
    ababbba
    bbb -> 1
    ababbba -> 2

    备注：
    40% 数据
 */

import java.util.HashSet;
import java.util.Scanner;

public class 字符游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder(s);
        while (n-- > 0) {
            int count = 0;
            String[] ops = sc.nextLine().split(" ");
            if (ops[0].equals("1")) {
                sb.setCharAt(Integer.parseInt(ops[1]) - 1, ops[2].charAt(0));
            } else if (ops[0].equals("2")) {
                int left = Integer.parseInt(ops[1]);
                int right = Integer.parseInt(ops[2]);
                String temp = sb.toString().substring(left - 1, right);
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < temp.length(); i++) {
                    if (!set.contains(temp.charAt(i))) {
                        count++;
                        set.add(temp.charAt(i));
                    }
                }
                System.out.println(count);
            }
        }
    }
}
