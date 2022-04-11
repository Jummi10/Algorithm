package practice.inflearn.section5_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static final char LEFT_BRACKET = '(';
    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); // 1줄

        String solution = main.solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        boolean isYes = true;

        int length = str.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char bracket = str.charAt(i);
            if (bracket == LEFT_BRACKET) {
                stack.push(LEFT_BRACKET);
            } else {
                if (stack.empty()) {
                    isYes = false;
                    break;
                }
                stack.pop();
            }
        }
        if (stack.size() != 0) {
            isYes = false;
        }

        if (isYes) {
            return YES;
        } else {
            return NO;
        }
    }
}