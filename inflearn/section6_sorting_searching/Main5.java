package practice.inflearn.section6_sorting_searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static final char DUPLICATION = 'D';
    public static final char UNIQUE = 'U';

    public static void main(String[] args) {
        Main5 main = new Main5();

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
        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            if (list.contains(number)) {
                isDuplicate = true;
                break;
            }
            list.add(number);
        }

        if (isDuplicate) {
            return DUPLICATION;
        } else {
            return UNIQUE;
        }
    }
}
