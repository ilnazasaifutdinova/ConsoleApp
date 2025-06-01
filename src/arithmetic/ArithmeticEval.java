package arithmetic;

// This class provides Arithmetic Expression Evaluation.

// No constructor is used — all methods work directly with the input data
// to keep the solution simple and avoid unnecessary complexity.

public class ArithmeticEval {
    public long evaluate(String expression) {
        if (expression == null || expression.isEmpty()) {
            System.out.println("Expression is null or empty");
            return 0; //return non-letters in the String
        }
        return 0;
    }
}
