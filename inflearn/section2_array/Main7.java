package practice.inflearn.section2_array;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Main7 main = new Main7();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        int solution = main.solution(scores);
        System.out.println(solution);
    }

    public static int solution(int[] scores) {
        int sum = 0;
        int plusScore = 0;
        for (int score : scores) {
            if (score == 0) {
                plusScore = 0;
                continue;
            }
            sum += (1 + plusScore);
            plusScore++;
        }

        return sum;
    }
}