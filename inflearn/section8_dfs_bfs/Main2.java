package practice.inflearn.section8_dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    private static int maxAvailableWeight;
    private static int dogNum;
    private static int[] dogWeights;
    private static int maxWeightSum = 0;

    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        maxAvailableWeight = in.nextInt();
        dogNum = in.nextInt();
        dogWeights = new int[dogNum];
        for (int i = 0; i < dogNum; i++) {
            dogWeights[i] = in.nextInt();
        }

        main.solution();
        System.out.println(maxWeightSum);
    }

    public static void solution() {
        calculateMaximumWeightSum(0, 0);
    }

    private static void calculateMaximumWeightSum(int sum, int level) {
        if (level == dogNum && maxWeightSum < sum && sum <= maxAvailableWeight) {
            maxWeightSum = sum;
            return;
        }

        if (sum > maxAvailableWeight || level == dogNum) {
            return;
        }

        calculateMaximumWeightSum(sum + dogWeights[level], level + 1);
        calculateMaximumWeightSum(sum, level + 1);
    }
}
