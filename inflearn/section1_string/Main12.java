package practice.inflearn.section1_string;

import java.util.Scanner;

public class Main12 {

    public static final char HASH = '#';

    public static void main(String[] args) {
        Main12 main = new Main12();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        String solution = main.solution(n, str);
        System.out.println(solution);
    }

    public static String solution(int n, String str) {
        char[] decoded = new char[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n * 7; i++) {
            if (str.charAt(i) == HASH) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String binaryNumber = sb.substring(7 * i, 7 * (i + 1));
            decoded[i] = binaryToChar(binaryNumber);
        }
        String binaryNumber = sb.substring(7 * (n - 1));
        decoded[n - 1] = binaryToChar(binaryNumber);

        return String.valueOf(decoded);
    }

    private static char binaryToChar(String binary) {
        int length = binary.length();
        int sum = 0;
        int bin = 1;

        // binary to decimal
        for (int i = length - 1; 0 <= i; i--) {
            sum += (binary.charAt(i) - 48) * bin;
            bin *= 2;
        }

        // decimal to char
        return (char) sum;
    }
}