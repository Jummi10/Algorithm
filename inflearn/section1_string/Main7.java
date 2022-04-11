package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main7 {
    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Main7 main = new Main7();

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String solution = solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        str = str.toLowerCase();
        int length = str.length();
        char[] chars = str.toCharArray();
        boolean isPalindromic = true;

        // 1번 풀이
        for (int l = 0, r = length - 1; l < r; l++, r--) {
            if (chars[l] != chars[r]) {
                isPalindromic = false;
                break;
            }
        }

        // 2번 풀이
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        if (!str.equals(reversed)) {
            isPalindromic = false;
        }

        if (isPalindromic) {
            return YES;
        } else {
            return NO;
        }
    }
}