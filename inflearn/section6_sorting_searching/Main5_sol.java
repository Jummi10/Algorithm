package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main5_sol {
    public static final char DUPLICATION = 'D';
    public static final char UNIQUE = 'U';

    public static void main(String[] args) {
        Main5_sol main = new Main5_sol();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        char solution = main.solution(n, numbers);
        System.out.println(solution);
    }

    public static char solution(int n, int[] numbers) {
        boolean isDuplicate = false;
        Arrays.sort(numbers);

        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            return DUPLICATION;
        } else {
            return UNIQUE;
        }
    }
}
