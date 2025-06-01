package arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This class provides Arithmetic Expression Evaluation.

// No constructor is used — all methods work directly with the input data
// to keep the solution simple and avoid unnecessary complexity.

public class ArithmeticEval {
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private List<String> tokenise(String input) {
        List<String> tokenised = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isDigit(ch)) {
                num.append(ch);
            } else if (ch == '.' && !num.isEmpty()) {
                num.append(ch);
            } else if (ch == '-' && (i == 0 || isOperator(input.charAt(i - 1)) || input.charAt(i - 1) == '(')) {
                num.append(ch); //minus for negative numbers
            } else {
                if (!num.isEmpty()) {
                    tokenised.add(num.toString());
                    num.setLength(0);
                }
                if ("+-*/()".indexOf(ch) != -1) {
                    tokenised.add(String.valueOf(ch));
                } else {
                    System.out.println("Unexpected character: " + ch);
                }
            }
        }
        if (!num.isEmpty()) {
            tokenised.add(num.toString());
        }
        return tokenised;
    }

    private int priority(String operations) {
        switch (operations) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private List<String> toRNP(List<String> tokens) {
        List<String> notation = new ArrayList<>();
        Stack<String> operations = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                notation.add(token);
            } else if (token.equals("(")) {
                operations.push(token);
            } else if (token.equals(")")) {
                while (!operations.empty() && !operations.peek().equals("(")) {
                    notation.add(operations.pop());
                }
                if (!operations.empty() && operations.peek().equals("(")) {
                    operations.pop(); //delete the bracket "("
                }
            } else if (isOperator(token.charAt(0))) {
                while (!operations.empty() && priority(operations.peek()) >= priority(token)) {
                    notation.add(operations.pop());
                }
                operations.push(token);
            }
        }
        while (!operations.empty()) {
            notation.add(operations.pop());
        }
        return notation;
    }

    private long evalRNP(List<String> rpn) {
        Stack<Double> stack = new Stack<>();

        for (String token: rpn) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                double oper1 = stack.pop();
                double oper2 = stack.pop();
                double expResult;
                switch (token) {
                    case "+":
                        expResult = oper1 + oper2;
                        break;
                    case "-":
                        expResult = oper2 - oper1;
                        break;
                    case "*":
                        expResult = oper1 * oper2;
                        break;
                    case "/":
                        if (oper2 == 0) throw new ArithmeticException("Division by zero");
                        expResult = oper2 / oper1;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + token);
                }
                stack.push(expResult);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return Math.round(stack.pop());
    }

    public long evaluate(String expression) {
        if (expression == null || expression.isEmpty()) {
            System.out.println("Expression is null or empty");
        }
        expression = expression.replaceAll("\\s+", "");
        List<String> tokens = tokenise(expression);
        List<String> rpn = toRNP(tokens);
        //System.out.println("Tokens: " + tokens);
        return evalRNP(rpn);
    }
}
