package 美团;

/*  表达式求值
    给出一个布尔表达式的字符串，比如 true or false and false，表达式只包含 true，false，and 和 or，现在要对这个表达式进行布尔求值，计算结果为真时输出 true、
    为假时输出 false，不合法的表达时输出 error（比如：true true）。表达式求值是注意 and 的优先级比 or 要高，比如：true or false and false，
    等价于 true or (false and false)，计算结果是 true。

    输入描述：
    输入第一行含布尔表达式字符串 s，s 只包含 true、false、and、or 几个单词（不会出现其他的任何单词），且单词之间用空格分隔。（1 <= |s| <= 10^3）

    输出描述：
    输出 true、false 或 error，true 表示布尔表达式计算为真，false 表示布尔表达式计算为假，error 表示一个不合法的表达式。

    输入例子 1：
    and
    输出例子 1：
    error

    输入例子 2：
    true and false
    输出例子 2：
    false

    输入例子 3：
    true or false and false
    输出例子 3：
    true
 */

import java.util.Scanner;
import java.util.Stack;

//  Stack
public class 表达式求值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            // 当前值为 true 或 false 时
            if (cur.equals("true") || cur.equals("false")) {
                if (stack.isEmpty()) {
                    stack.push(cur);
                } else {
                    String top = stack.peek();
                    if (top.equals("true") || top.equals("false")) {
                        System.out.println("error");
                        return;
                    } else {
                        if (top.equals("or")) {
                            stack.push(cur);
                        } else {
                            stack.pop();
                            String pre = stack.pop();
                            if (cur.equals("false") || pre.equals("false")) {
                                stack.push("false");
                            } else {
                                stack.push("true");
                            }
                        }
                    }
                }
            // 当前值为 and 或 or 时
            } else {
                if (stack.isEmpty()) {
                    System.out.println("error");
                    return;
                } else {
                    String top = stack.peek();
                    if (top.equals("and") || top.equals("or")) {
                        System.out.println("error");
                        return;
                    }
                    stack.push(cur);
                }
            }
        }
        if (!stack.isEmpty() && (stack.peek().equals("or") || stack.peek().equals("and"))) {
            System.out.println("error");
            return;
        }
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals("true")) {
                System.out.println("true");
                break;
            }
            if (stack.isEmpty()) {
                System.out.println("false");
            }
        }
    }
}
