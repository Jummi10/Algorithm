package practice.inflearn.section1_string;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Main5 main = new Main5();

        Scanner in = new Scanner(System.in);
        String str = in.next(); // 단어 하나

        String solution = solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        char[] chars = str.toCharArray();
        int length = str.length();
        for (int l = 0, r = length - 1; l < r;) {
            if (isAlphabet(chars[l]) && !isAlphabet(chars[r])) {
                r--;
                continue;
            }
            if (!isAlphabet(chars[l]) && isAlphabet(chars[r])) {
                l++;
                continue;
            }

            if (isAlphabet(chars[l]) && isAlphabet(chars[r])) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
            }
            l++;
            r--;
        }

        return String.valueOf(chars);
    }

    private static boolean isAlphabet(char ch) {
        return Character.isAlphabetic(ch);
    }
}