package 字节跳动;

/*  字符替换
    有一个仅包含’a’和’b’两种字符的字符串s，长度为n，每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，或者把一个’b’置成’a’)；
    但是操作的次数有上限m，问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。

    输入描述：
    第一行两个整数 n , m (1<=m<=n<=50000)，第二行为长度为n且只包含’a’和’b’的字符串s。

    输出描述：
    输出在操作次数不超过 m 的情况下，能够得到的 最大连续 全’a’子串或全’b’子串的长度。

    输入例子：
    8 1
    aabaabaa

    输出例子：
    5

    例子说明：把第一个 'b' 或者第二个 'b' 置成 'a'，可得到长度为 5 的全 'a' 子串。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字符替换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        System.out.print(Math.max(change(n, m, s, 'a'), change(n, m, s, 'b')));
    }

    private static int change(int n, int m, String s, char target) {
        int max = 0;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == target) {
                sums.add(i);
            }
        }
        if (sums.size() <= m) {
            return n;
        }
        sums.add(s.length());
        max = sums.get(m);
        for (int i = m + 1; i < sums.size(); i++) {
            max = Math.max(max, sums.get(i) - sums.get(i - m - 1) - 1);
        }
        return max;
    }
}
