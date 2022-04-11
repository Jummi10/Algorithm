package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Main11 main = new Main11();

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String solution = main.solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        int length = str.length();
        char ch = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < length; i++) {
            char c = str.charAt(i);
            if (ch == c) {
                count++;
            } else {
                sb.append(ch);
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
                ch = c;
            }
        }
        sb.append(ch);
        if (count > 1) {
            sb.append(count);
        }

        return sb.toString();
    }
}