package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main7_memoization {
    public static void main(String[] args) {
        Main7_memoization main = new Main7_memoization();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();

        int solution = main.solution(n, r);
        System.out.println(solution);
    }

    public static int solution(int n, int r) {
        int[][] combination = new int[n + 1][r + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= r; j++) {
                if (j == 0 || i == j) { // r == 0 || n == r
                    combination[i][j] = 1;
                }
                if (j == 1) {   // r == 1
                    combination[i][j] = i;
                }
            }
        }

        return getCombination(n, r, combination);
    }

    private static int getCombination(int n, int r, int[][] combination) {
        if (combination[n][r] == 0) {
            combination[n][r] = getCombination(n - 1, r - 1, combination) + getCombination(n - 1, r, combination);
        }

        return combination[n][r];
    }
}
