package 美团;

/*  删除字符
    将给定的字符串，按照规则删除字符，输出删除后的字符串。
    删除规则为：相同字符联系，则删除，如 'aaaab' 删除后的字符串为 'b'。
    注：仅是单个字符连续才删除，如 babababa 则不能删除；

    输入描述：
    输入数据有多组，每组一行，仅包含数字和英文数字，不包含转义等其他特殊字符，输入数据最大长度为 10；

    输出描述：
    对于每个测试实例，要求输出按规则删除后的数据，每个测试实例的输出占一行。
    如果删除后有字符，直接输出删除后的字符；如果删除后为空，则输出 “no”

    输入例子 1：
    a
    aaaaabbbb

    输出例子 1：
    a
    no
 */

import java.util.Scanner;
//  Two Pointers
public class 删除字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            // i 记录连续子串的头部
            for (int i = 0; i < s.length(); i++) {
                // j 为移动指针，记录连续子串的尾部
                int j = i;
                // 若后一个字符跟当前一样，则 j 后移一位
                while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                }
                // i j 相等说明不是连续的，拼接之
                if (i == j) {
                    sb.append(s.charAt(i));
                // 当前子串是连续，跳过
                } else {
                    i = j;
                }
            }
            if (sb.toString().equals("")) {
                System.out.println("no");
            } else {
                System.out.println(sb);
            }
        }
    }
}
