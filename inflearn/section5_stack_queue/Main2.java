package practice.inflearn.section5_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static final char LEFT_BRACKET = '(';
    public static final char RIGHT_BRACKET = ')';

    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String solution = main.solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        int length = str.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isInBrackets = false;

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == LEFT_BRACKET) {
                stack.push(i);
                isInBrackets = true;
                continue;
            }
            if (c == RIGHT_BRACKET) {
                stack.pop();
                if (stack.empty()) {
                    isInBrackets = false;
                }
                continue;
            }
            if (!isInBrackets) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}