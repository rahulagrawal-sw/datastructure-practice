package stack;

import java.util.Stack;

public class EvaluatePostfixExpression {

    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }

    private static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        int result =0;
        for(String ch: exp.split(" ")) {
            int num1, num2;

            switch (ch) {
                case "+":
                     num1 = stack.pop();
                     num2 = stack.pop();
                     result = num2+num1;
                    stack.push(result);
                    break;
                case "-":
                     num1 = stack.pop();
                     num2 = stack.pop();
                     result = num2-num1;
                    stack.push(result);
                    break;
                case "*":
                     num1 = stack.pop();
                     num2 = stack.pop();
                     result = num2*num1;
                    stack.push(result);
                    break;
                case "/":
                     num1 = stack.pop();
                     num2 = stack.pop();
                     result = num2/num1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.valueOf(ch));
                    break;
            }
        }

        return result;
    }
}
