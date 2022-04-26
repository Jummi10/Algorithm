package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main3 {
    private static int maxScore = 0;
    private static int problemNum;
    private static int limitTime;
    private static int[] scores;
    private static int[] times;

    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner in = new Scanner(System.in);
        problemNum = in.nextInt();
        limitTime = in.nextInt();
        scores = new int[problemNum];
        times = new int[problemNum];
        for (int i = 0; i < problemNum; i++) {
            scores[i] = in.nextInt();
            times[i] = in.nextInt();
        }

        main.solution(limitTime, scores, times);
        System.out.println(maxScore);
    }

    public static void solution(int limitTime, int[] scores, int[] times) {
        calculateMaxScore(0, 0, 0);
    }

    private static void calculateMaxScore(int timeSum, int scoreSum, int index) {
        if (index == problemNum && timeSum <= limitTime && maxScore < scoreSum) {
            maxScore = scoreSum;
            return;
        }

        if (index == problemNum || timeSum > limitTime) {
            return;
        }

        calculateMaxScore(timeSum + times[index], scoreSum + scores[index], index + 1);
        calculateMaxScore(timeSum, scoreSum, index + 1);
    }
}
