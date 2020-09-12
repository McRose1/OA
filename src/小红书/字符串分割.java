package 小红书;

/*  字符串分割
    给定一个非空的字符串s ，将s切割成若干个非空子串，要求每个子串头尾是相同字符 ，给出切割的子串的数量最少的方法。

    输入描述
    一个非空的字符串s

    输出描述
    满足要求的切割结果的子串数量

    样例输入
    abaccd
    样例输出
    3

    提示
    1、字符串有很多种切割的方法，使得切割出来的子串头尾是相同字符，本题要求找出其中一种切割的方法，使得它切割之后的子串数量是最少的。
       并把这个切割方法的子串数量作为输出

    2、比如一个字符串为"abaccd",那么切割成"aba"、"cc"、"d"3个子串是满足条件的，输出结果就是 3
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  (50%)

 */
public class 字符串分割 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int n = s.length();
        List<Integer> len = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    len.add(1);
                }
                if (s.charAt(i) == s.charAt(j)) {
                    len.add(j - i + 1);
                }
            }
        }
        len.sort((a, b) -> b - a);
        if (len.get(0) == n) {
            return 0;
        } else {
            int count = 1;
            n -= len.get(0);
            int idx = 1;
            while (n != 0) {
                count++;
                n -= len.get(idx++);
            }
            return count;
        }
    }
}
