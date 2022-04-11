package practice.inflearn.section2_array;

import java.util.Scanner;

public class Main3 {
    /*
    1 가위, 2 바위, 3 보
    A || 1 2 3 | 1 2 3 | 2 3 1
    B || 1 2 3 | 3 1 2 | 3 1 2
    R || D D D | A A A | B B B
     */

    public static final char A_WIN = 'A';
    public static final char B_WIN = 'B';
    public static final char DRAW = 'D';

    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] aInfo = new int[n], bInfo = new int[n];
        for (int i = 0; i < n; i++) {
            aInfo[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bInfo[i] = in.nextInt();
        }

        char[] solution = main.solution(n, aInfo, bInfo);
        for (char result : solution) {
            System.out.println(result);
        }
    }

    public static char[] solution(int n, int[] aInfo, int[] bInfo) {
        char[] results = new char[n];
        for (int i = 0; i < n; i++) {
            int a = aInfo[i], b = bInfo[i];
            if (a == b) {
                results[i] = DRAW;
                continue;
            }

            if ((a - b + 3) % 3 == 1) {
                results[i] = A_WIN;
                continue;
            }
            results[i] = B_WIN; // (a - b + 3) % 3 == 2
        }

        return results;
    }
}