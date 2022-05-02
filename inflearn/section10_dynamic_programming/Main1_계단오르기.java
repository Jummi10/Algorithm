package practice.inflearn.section10_dynamic_programming;

import java.util.Scanner;

public class Main1_계단오르기 {
    public static void main(String[] args) {
        Main1_계단오르기 main = new Main1_계단오르기();

        Scanner in = new Scanner(System.in);
        int stairCount = in.nextInt();

        int solution = main.solution(stairCount);
        System.out.println(solution);
    }

    public static int solution(int stairCount) {
        int[] counts = new int[stairCount + 1];
        counts[1] = 1;
        counts[2] = 2;

        for (int i = 3; i <= stairCount; i++) {
            counts[i] = counts[i - 2] + counts[i - 1];
        }

        return counts[stairCount];
    }
}
