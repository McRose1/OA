package 华为;

/*  四则运算

    约束：

    pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。

    pucExpression算术表达式的有效性由调用者保证;

    输入描述:
    输入一个算术表达式

    输出描述:
    得到计算结果

    示例1
    输入
    3+2*{1+2*[-4/(8-6)+7]}
    输出
    25
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
    这题非常好
 */
public class 四则运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String post = transform(s);
        int res = calculate(post);
        System.out.println(res);
    }

    private static Stack<Character> op = new Stack<>();
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> count = new ArrayList<>();

    // 给定中缀表达式，将其转换成后缀表达式（逆波兰式）
    // 3+2*{1+2*[-4/(8-6)+7}} -> 32120486-/-7+*+
    private static String transform(String s) {
        // 把所有括号都换成小括号，以便减少后期过多的判断
        String temp = s.replace('{', '(').replace('}', ')').replace('[', '(').replace(']', ')');
        char[] ch = temp.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (Character.isDigit(c)) {
                // 记录连续出现数字的个数，也就是反映了数字的位数
                int cnt = 0;
                while (i < ch.length && Character.isDigit(ch[i])) {
                    sb.append(ch[i]);
                    i++;
                    cnt++;
                }
                i--;
                count.add(cnt);
            } else if (c == '(') {
                op.push(c);
            } else if (c == '+' || c == '-') {
                // (-4) -> 04- -> (0-4)
                if (c == '-' && ch[i - 1] == '(') {
                    sb.append('0');
                    count.add(1);
                }
                // 如果栈顶优先级不比自己低，就一直出栈将栈顶加入逆波兰式，直到遇到 '(' 或 ')'
                while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/' || op.peek() == '+' || op.peek() == '-')) {
                    sb.append(op.pop());
                }
                op.push(c);
            } else if (c == '*' || c == '/') {
                // 遇到 * 或 / 就一直出栈加入逆波兰式，直到栈顶是优先级比自己低的符号才入栈
                while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    sb.append(op.pop());
                }
                op.push(c);
            } else {
                // 开始结算这一对括号里的表达式
                while (!op.isEmpty() && op.peek() != '(') {
                    sb.append(op.pop());
                }
                // poll 出 '(' 本身
                op.pop();
            }
        }
        while (!op.isEmpty()) {
            sb.append(op.pop());
        }
        return sb.toString();
    }

    // 逆波兰式计算
    private static int calculate(String s) {
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (Character.isDigit(c)) {
                int sum = 0;
                int cnt = count.get(idx);
                while (cnt-- > 0) {
                    sum = sum * 10 + (ch[i++] - '0');
                }
                i--;
                stack.push(sum);
                idx++;
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (c == '+') {
                    stack.push(num1 + num2);
                } else if (c == '-') {
                    stack.push(num2 - num1);
                } else if (c == '*') {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
}
