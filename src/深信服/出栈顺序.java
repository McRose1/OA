package 深信服;

/*  出栈顺序
    已知某一个字母序列，把序列中的字母按出现顺序压入一个栈，在入栈的任意过程中，允许栈中的字母出栈，求所有可能的出栈顺序

    输入描述:
    字符串，如：abc

    输出描述:
    可能的出栈顺序，每行一种顺序

    输入例子1:
    abc

    输出例子1:
    abc
    acb
    bac
    bca
    cba
 */

import java.util.Scanner;
import java.util.Stack;

public class 出栈顺序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        helper(0, stack, "");
    }

    private static char[] ch;

    private static void helper(int n, Stack<Character> stack, String s) {
        if (n == ch.length && stack.isEmpty()) {
            System.out.println(s);
        } else {
            Stack<Character> s1 = (Stack<Character>) stack.clone();
            Stack<Character> s2 = (Stack<Character>) stack.clone();

            // 出栈
            if (!s2.isEmpty()) {
                String temp = s + s2.pop();
                helper(n, s2, temp);
            }

            // 入栈
            if (n < ch.length) {
                s1.push(ch[n]);
                helper(n + 1, s1, s);
            }
        }
    }
}
