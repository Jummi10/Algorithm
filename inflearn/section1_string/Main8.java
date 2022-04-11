package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main8 {
    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Main8 main = new Main8();

        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        String solution = solution(sentence);
        System.out.println(solution);
    }

    public static String solution(String sentence) {
        sentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(sentence);
        String reversed = sb.reverse().toString();
        boolean isPalindromic = true;
        if (!sentence.equals(reversed)) {
            isPalindromic = false;
        }

        if (isPalindromic) {
            return YES;
        } else return NO;
    }
}