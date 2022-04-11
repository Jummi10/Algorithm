package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main12_sol {

    public static final char ASTERISK = '*';
    public static final char HASH = '#';
    public static final char ZERO = '0';
    public static final char ONE = '1';

    public static void main(String[] args) {
        Main12_sol main = new Main12_sol();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        String solution = main.solution(n, str);
        System.out.println(solution);
    }

    public static String solution(int n, String str) {
        char[] decoded = new char[n];
        str = str.replace(ASTERISK, ZERO).replace(HASH, ONE);

        for (int i = 0; i < n - 1; i++) {
            String binaryNumber = str.substring(7 * i, 7 * (i + 1));
            decoded[i] = binaryToChar(binaryNumber);
        }
        String binaryNumber = str.substring(7 * (n - 1));
        decoded[n - 1] = binaryToChar(binaryNumber);

        return String.valueOf(decoded);
    }

    private static char binaryToChar(String binary) {
        return (char) Integer.parseInt(binary, 2);  // radix: 진법의 기수
    }
}