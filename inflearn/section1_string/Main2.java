package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String solution = solution(str);
        System.out.println(solution);
    }

    public static String solution(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 65 && ch <= 90) {
                sb.append((char) (ch + 32));
            } else {
                sb.append((char) (ch - 32));
            }
        }

        return sb.toString();
    }
}