package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main9 {

    public static final String REGEX = "[^0-9]";

    public static void main(String[] args) {
        Main9 main = new Main9();

        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        int solution = solution(sentence);
        System.out.println(solution);
    }

    public static int solution(String str) {
        String s = str.replaceAll(REGEX, "");
        return Integer.parseInt(s);
    }
}