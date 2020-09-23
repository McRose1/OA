package 好未来;

/*  删除公共字符
    输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
    例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”

    输入描述:
    每个测试输入包含2个字符串

    输出描述:
    输出删除后的字符串

    输入例子1:
    They are students.
    aeiou

    输出例子1:
    Thy r stdnts.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 删除公共字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
