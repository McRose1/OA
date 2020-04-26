package Robolox;

/*  GfG
    Given a Prefix expression, convert it into a Postfix expression.

    Prefix: An expression is called the prefix expression if the operator appears in the expression before the operands.
    Simply of the form (operator operand1 operand2).
    Example : *+AB-CD (Infix : (A+B) * (C-D) )

    Postfix: An expression is called the postfix expression if the operator appears in the expression after the operands.
    Simply of the form (operand1 operand2 operator).
    Example : AB+CD-* (Infix : (A+B * (C-D) )

    Examples:
    Input :  Prefix :  *+AB-CD
    Output : Postfix : AB+CD-*
    Explanation : Prefix to Infix :  (A+B) * (C-D)
                  Infix to Postfix :  AB+CD-*

    Input :  Prefix :  *-A/BC-/AKL
    Output : Postfix : ABC/-AK/L-*
    Explanation : Prefix to Infix :  A-(B/C)*(A/K)-L
                  Infix to Postfix : ABC/-AK/L-*
 */

import java.util.Stack;

public class PrefixtoPostfix {
    public static String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();

        int len = pre_exp.length();

        for (int i = len - 1; i >= 0; i--) {
            if (isOperator(pre_exp.charAt(i))) {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();

                String temp = op1 + op2 + pre_exp.charAt(i);

                stack.push(temp);
            } else {
                stack.push(pre_exp.charAt(i) + "");
            }
        }
        return stack.peek();
    }

    private static boolean isOperator(char c) {
        switch (c)
        {
            case '+':
            case '-':
            case '/':
            case '*':
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String pre_exp1 = "*+AB-CD";
        String s1 = preToPost(pre_exp1);
        System.out.println(s1);

        String pre_exp2 = "*-A/BC-/AKL";
        String s2 = preToPost(pre_exp2);
        System.out.println(s2);
    }
}
