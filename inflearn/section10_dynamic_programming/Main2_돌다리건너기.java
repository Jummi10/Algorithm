package practice.inflearn.section10_dynamic_programming;

import java.util.Scanner;

public class Main2_돌다리건너기 {
    public static void main(String[] args) {
        Main2_돌다리건너기 main = new Main2_돌다리건너기();

        Scanner in = new Scanner(System.in);
        int rockCount = in.nextInt();

        int solution = main.solution(rockCount);
        System.out.println(solution);
    }

    public static int solution(int rockCount) {
        int[] counts = new int[rockCount + 2];
        counts[1] = 1;
        counts[2] = 2;
        for (int i = 3; i < rockCount + 2; i++) {
            counts[i] = counts[i - 2] + counts[i - 1];
        }

        return counts[rockCount + 1];
    }
}
