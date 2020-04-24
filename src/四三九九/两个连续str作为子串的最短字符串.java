package 四三九九;

/*  两个连续str作为子串的最短字符串
    给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".

    输入描述：
    输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母.

    输出描述：
    输出一个字符串,即含有连续两个s作为子串的最短字符串。

    输入例子：
    abracadabra

    输出例子：
    abracadabracadabra

 */
//  KMP
import java.util.Scanner;

public class 两个连续str作为子串的最短字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int overlap = KMP(s);
        String res = "";
        res = s + s.substring(overlap);
        System.out.println(res);
    }

    private static int KMP(String s) {
        int[] pi = new int[s.length()];
        pi[0] = 0;
        // 前缀
        int k = 0;
        // 后缀
        int j = 1;

        while (j < s.length()) {
            if (s.charAt(k) == s.charAt(j)) {
                k++;
                pi[j] = k;
                j++;
            } else {
                if (k != 0) {
                    k = pi[k - 1];
                } else {
                    pi[j] = k;
                    j++;
                }
            }
        }
        return pi[s.length() - 1];
    }
}
