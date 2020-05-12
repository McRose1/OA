package 映客;

import java.util.Stack;

public class 括号闭合 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return true;
    }
}
