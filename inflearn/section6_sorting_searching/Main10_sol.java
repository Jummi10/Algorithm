package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main10_sol {
    public static void main(String[] args) {
        Main10_sol main = new Main10_sol();

        Scanner in = new Scanner(System.in);
        int stableCount = in.nextInt();
        int horseCount = in.nextInt();
        int[] stables = new int[stableCount];
        for (int i = 0; i < stableCount; i++) {
            stables[i] = in.nextInt();
        }

        int solution = main.solution(stableCount, horseCount, stables);
        System.out.println(solution);
    }

    public static int solution(int stableCount, int horseCount, int[] stables) {
        Arrays.sort(stables);
        int maxDistanceBetweenStables = 0;

        // 마구간 사이의 최소 거리 left, 최대 거리 right, 찾아야하는 가장 가까운 두 말의 최대 거리 = middle
        int left = 0, right = stables[stableCount - 1] - stables[0], middle;
        for (int i = 1; i < stableCount; i++) {
            int distance = stables[i] - stables[i - 1];
            if (left > distance) {
                left = distance;
            }
        }

        int horseCountInStable = 1, previousHorseIndex = 0, nextHorseIndex = 1;
        while (left <= right) {
            middle = (left + right) / 2;

            while (nextHorseIndex <= stableCount - 1) {
                if (stables[nextHorseIndex] - stables[previousHorseIndex] >= middle) {
                    horseCountInStable++;
                    previousHorseIndex = nextHorseIndex;
                }

                nextHorseIndex++;
            }

            if (horseCountInStable >= horseCount) {
                maxDistanceBetweenStables = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }

            horseCountInStable = 1;
            previousHorseIndex = 0;
            nextHorseIndex = 1;
        }

        return maxDistanceBetweenStables;
    }
}
