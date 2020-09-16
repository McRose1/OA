package 小米;

/*  字符串有效判断
    给定一个只包括'(',')','{','}','[',']' 的字符串,判断字符串是否有效。

    有效字符串需满足:

       1.左括号必须用相同类型的右括号闭合。

       2. 左括号必须以正确的顺序闭合。

    注意空字符串可被认为是有效字符串。

    输入描述
    待判断的字符串，多个字符串需换行输入

    输出描述
    每个字符串的判断结果，多个结果需换行输出

    样例输入
    ()[]{}
    ([)]
    {[]}
    样例输出
    true
    false
    true
 */

import java.util.Scanner;
import java.util.Stack;

public class 字符串有效判断 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s == null || s.length() == 0) {
                System.out.println("true");
            } else {
                Stack<Character> stack = new Stack<>();
                boolean match = true;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '(' || c == '[' || c == '{') {
                        stack.push(c);
                    } else if (c == ')') {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            match = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    } else if (c == ']') {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            match = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    } else if (c == '}') {
                        if (stack.isEmpty() || stack.peek() != '{') {
                            match = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
                if (match) {
                    if (!stack.isEmpty()) {
                        System.out.println("false");
                    } else {
                        System.out.println("true");
                    }
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}
