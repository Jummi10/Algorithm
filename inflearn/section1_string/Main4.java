package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next(); // 단어 하나
            String solution = solution(str);
            System.out.println(solution);
        }
    }

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}