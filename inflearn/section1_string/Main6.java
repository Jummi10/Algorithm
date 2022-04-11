package practice.inflearn.section1_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Main6 main = new Main6();

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String solution = solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        List<Character> word = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!word.contains(ch)) {
                word.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : word) {
            sb.append(ch);
        }

        return sb.toString();
    }
}