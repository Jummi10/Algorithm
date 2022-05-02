package practice.inflearn.section10_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Main6_최대점수_냅색_sol {
    public static void main(String[] args) {
        Main6_최대점수_냅색_sol main = new Main6_최대점수_냅색_sol();

        Scanner in = new Scanner(System.in);
        int problemCount = in.nextInt();
        int limitTime = in.nextInt();
        Problem[] problems = new Problem[problemCount];
        for (int i = 0; i < problemCount; i++) {
            problems[i] = new Problem(in.nextInt(), in.nextInt());
        }

        int solution = main.solution(limitTime, problems);
        System.out.println(solution);
    }

    public static int solution(int limitTime, Problem[] problems) {
        int[] maxScores = new int[limitTime + 1];   // idx 시간에 낼 수 있는 최대 점수의 합
        Arrays.fill(maxScores, 0);

        for (Problem problem : problems) {
            for (int time = limitTime; time >= problem.time; time--) {  // 개수가 1개로 제한될 때는 뒤에서부터 순회해야지 중복을 회피한다.
                maxScores[time] = Math.max(maxScores[time], maxScores[time - problem.time] + problem.score);
            }
        }

        return maxScores[limitTime];
    }

    static class Problem {
        private final int score;
        private final int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
