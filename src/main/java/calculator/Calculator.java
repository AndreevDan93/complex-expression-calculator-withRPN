package calculator;

import java.util.Stack;

public class Calculator {
    public int calculate(String expression) {
        String preparedExpression = prepareExpression(expression);
        String rpn = expressionToRPN(preparedExpression);
        return rpnToAnswer(rpn);
    }

    private int rpnToAnswer(String rpn) {
        StringBuilder operand = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            char currentChar = rpn.charAt(i);

            if (currentChar == ' ') {
                continue;
            }

            if (getPriority(rpn.charAt(i)) == 0) {
                while (getPriority(rpn.charAt(i)) == 0 && rpn.charAt(i) != ' ') {
                    operand.append(rpn.charAt(i++));
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Integer.parseInt(operand.toString()));
                operand.delete(0, operand.length());
            }
            if (getPriority(rpn.charAt(i)) > 1) {

                int a = stack.pop();
                int b = stack.pop();

                switch (rpn.charAt(i)) {
                    case '*' -> stack.push(b * a);
                    case '/' -> stack.push(b / a);
                    case '-' -> stack.push(b - a);
                    case '+' -> stack.push(b + a);
                    default -> throw new RuntimeException();
                }
            }
        }

        return stack.pop();
    }

    private String prepareExpression(String expression) {
        StringBuilder preparedExp = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == ' ') {
                continue;
            }
            if (currentChar == '-') {
                if (i == 0 || getPriority(expression.charAt(i - 1)) > 0) {
                    preparedExp.append('0');
                }
            }
            preparedExp.append(currentChar);
        }
        return preparedExp.toString();
    }

    private String expressionToRPN(String expression) {
        StringBuilder rpn = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {

            char currentChar = expression.charAt(i);
            int priority = getPriority(currentChar);

            switch (getPriority(currentChar)) {
                case 0 -> rpn.append(currentChar);
                case 1 -> stack.push(currentChar);
                case -1 -> {
                    rpn.append(' ');
                    while (getPriority(stack.peek()) != 1) {
                        rpn.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    rpn.append(' ');
                    while (!stack.empty()) {
                        if (getPriority(stack.peek()) >= priority) {
                            rpn.append(stack.pop());
                            rpn.append(' ');
                        } else {
                            break;
                        }
                    }
                    stack.push(currentChar);
                }

            }
        }
        while (!stack.empty()) {
            rpn.append(stack.pop());
        }

        return rpn.toString();
    }

    private int getPriority(char token) {
        return switch (token) {
            case '*', '/' -> 3;
            case '+', '-' -> 2;
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }
}
