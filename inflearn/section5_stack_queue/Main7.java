package practice.inflearn.section5_stack_queue;

import java.util.Scanner;

public class Main7 {

    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Main7 main = new Main7();

        Scanner in = new Scanner(System.in);
        String compulsoryCourseSequence = in.nextLine();
        String courses = in.nextLine();

        String solution = main.solution(compulsoryCourseSequence, courses);
        System.out.println(solution);
    }

    public static String solution(String compulsoryCourseSequence, String courses) {
        int sequenceLength = compulsoryCourseSequence.length();
        int coursesLength = courses.length();

        int s = 0, c = 0;
        while (s != sequenceLength && c != coursesLength) {
            char compulsoryCourse = compulsoryCourseSequence.charAt(s);
            char course = courses.charAt(c);
            if (compulsoryCourse == course) {
                s++;
                c++;
                continue;
            }

            c++;
        }

        if (s == sequenceLength) {
            return YES;
        } else {
            return NO;
        }
    }
}
