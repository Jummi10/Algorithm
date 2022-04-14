package practice.inflearn.section5_stack_queue;

import java.util.Scanner;

public class Main5 {

    public static final char OPEN_BRACE = '(';
    public static final char CLOSE_BRACE = ')';
    public static final String BRACES = "()";

    public static void main(String[] args) {
        Main5 main = new Main5();

        Scanner in = new Scanner(System.in);
        String lasers = in.nextLine();

        int solution = main.solution(lasers);
        System.out.println(solution);
    }

    public static int solution(String lasers) {
        int length = lasers.length();
        int count = 0;

        int stickCount = 0;
        for (int i = 0; i < length - 2; i++) {
            String laser = lasers.substring(i, i + 2);
            if (laser.equals(BRACES)) {
                count += stickCount;
                i++;
                continue;
            }

            char c = lasers.charAt(i);
            if (c == OPEN_BRACE) {
                stickCount++;
            } else if (c == CLOSE_BRACE) {
                count++;
                stickCount--;
            }
        }

        String laser = lasers.substring(length - 2);
        if (laser.equals(BRACES)) { // ~()
            return count;
        }

        laser = lasers.substring(length - 3, length - 1);
        if (laser.equals(BRACES)) { // ~())
            return ++count;
        }

        count += 2; // ~())) or ~))))
        return count;
    }
}
