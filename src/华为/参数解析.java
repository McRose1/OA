package 华为;

/*  参数解析
    在命令行输入如下命令：

    xcopy /s c:\ d:\，

    各个参数如下：

    参数1：命令字xcopy

    参数2：字符串/s

    参数3：字符串c:\

    参数4: 字符串d:\

    请编写一个参数解析程序，实现将命令行各个参数解析出来。

    解析规则：

    1.参数分隔符为空格
    2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
    3.参数不定长
    4.输入由用例保证，不会出现不符合要求的输入

    输入描述:
    输入一行字符串，可以有空格

    输出描述:
    输出参数个数，分解后的参数，每个参数都独占一行

    示例1
    输入
    xcopy /s c:\\ d:\\
    输出
    4
    xcopy
    /s
    c:\\
    d:\\
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 参数解析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.contains("\"")) {
            int count = 0;
            Stack<Character> stack = new Stack<>();
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            while (idx < s.length()) {
                if (s.charAt(idx) == '"') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push('"');
                    }
                } else if (stack.isEmpty() && s.charAt(idx) == ' ') {
                    count++;
                    list.add(sb.toString());
                    sb = new StringBuilder();
                } else if (s.charAt(idx) != ' ') {
                    sb.append(s.charAt(idx));
                }
                idx++;
            }
            if (sb.length() != 0) {
                list.add(sb.toString());
                count++;
            }
            System.out.println(count);
            for (String res : list) {
                System.out.println(res);
            }
        } else {
            String[] str = s.split(" ");
            int n = str.length;
            System.out.println(n);
            for (String value : str) {
                System.out.println(value);
            }
        }
    }
}
