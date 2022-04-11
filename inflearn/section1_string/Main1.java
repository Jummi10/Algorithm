package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        String str = in.next();
        char ch = in.next().charAt(0);

        int solution = solution(str, ch);
        System.out.println(solution);
    }

    public static int solution(String str, char ch) {
        int length = str.length();
        str = str.toLowerCase();
        if (ch >= 65 && ch <= 90) {
            ch += 32;
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == ch) {
                count++;
            }
        }

        return count;
    }
}
