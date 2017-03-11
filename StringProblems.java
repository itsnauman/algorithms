package com.company;

import java.util.Stack;

/**
 * Solutions to String interview problems.
 */
public class StringProblems {
    public static int excelColumnNumber(String a) {
        int num = 0;

        for (int i = 0; i < a.length(); i++) {
            char ex = a.charAt(i);

            num *= 26;

            num += 'A' - ex + 1;
        }

        return num;
    }

    public static boolean isUnique(String s) {
        boolean characters[] = new boolean['a' - 'Z' + 1];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (characters[ch])
                return false;

            characters[ch] = true;
        }

        return true;
    }

    public static int reversePolishEval(String ex) {
        Stack<String> stack = new Stack<>();
        String ops = "+-/*";

        for (int i = 0; i < ex.length(); i++) {
            char t = ex.charAt(i);

            if (ops.indexOf(t) != -1) {
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());

                switch (Character.toString(t)) {
                    case "*":
                        stack.push(Integer.toString(op1 * op2));
                        break;
                    case "+":
                        stack.push(Integer.toString(op1 + op2));
                        break;
                    case "-":
                        stack.push(Integer.toString(op1 - op2));
                        break;
                    case "/":
                        stack.push(Integer.toString(op1 / op2));
                }
            } else {
                stack.push(Character.toString(t));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
