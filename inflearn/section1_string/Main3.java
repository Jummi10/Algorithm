package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main3 {

    public static final String DELIMETER = "\\s+";

    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String solution = solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        str = str.trim();
        String[] words = str.split(DELIMETER);
        String mostLongestWord = "";
        int longestLength = 0;
        for (String word : words) {
            int length = word.length();
            if (length > longestLength) {
                mostLongestWord = word;
                longestLength = length;
            }
        }

        return mostLongestWord;
    }
}