package arithmetic;

import java.util.ArrayList;
import java.util.List;

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
            } else if (ch == '.' && num.length() > 0) {
                num.append(ch);
            } else if (ch == '-' && (i == 0 || isOperator(input.charAt(i - 1)) || input.charAt(i - 1) == '(')) {
                num.append(ch); //minus for negative numbers
            } else {
                if (num.length() > 0) {
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
        if (num.length() > 0) {
            tokenised.add(num.toString());
        }
        return tokenised;
    }

    private List<String> toRNP(List<String> tokens) {
        return tokens;
    }

    private long evalRNP(List<String> rpn) {
        return Long.parseLong(rpn.get(0));
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
