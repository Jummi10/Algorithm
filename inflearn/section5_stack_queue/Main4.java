package practice.inflearn.section5_stack_queue;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();

        int solution = main.solution(operation);
        System.out.println(solution);
    }

    public static int solution(String operation) {
        Stack<Double> stack = new Stack<>();
        for (char ch : operation.toCharArray()) {
            if (ch >= 49 && ch <= 57) { // 1~9
                stack.push(ch - 48.0);
                continue;
            }

            double second = stack.pop();
            double first = stack.pop();
            if (ch == '+') {
                stack.push(first + second);
            } else if (ch == '-') {
                stack.push(first - second);
            } else if (ch == '*') {
                stack.push(first * second);
            } else if (ch == '/') {
                stack.push(first / second);
            }
        }

        return stack.pop().intValue();
    }
}
