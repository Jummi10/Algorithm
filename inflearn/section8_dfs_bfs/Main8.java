package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main8 {
    private static boolean isFound = false;

    public static void main(String[] args) {
        Main8 main = new Main8();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();

        main.solution(n, target);
    }

    public static void solution(int n, int target) {
        boolean[] isUsed = new boolean[n + 1];
        int[][] triangle = new int[n + 1][n + 1];
        makePascalTriangle(n, target, triangle, isUsed, 0);
    }

    private static void makePascalTriangle(int n, int target, int[][] triangle, boolean[] isUsed, int level) {
        if (isFound) {
            return;
        }

        if (level == n) {
            int sum = addTriangle(triangle, n);
            if (sum == target) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(triangle[1][i] + " ");
                }
                System.out.println();
                isFound = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                triangle[1][level + 1] = i;
                makePascalTriangle(n, target, triangle, isUsed, level + 1);
                isUsed[i] = false;
            }
        }
    }

    private static int addTriangle(int[][] triangle, int n) {
        for (int row = 1; row < n; row++) {
            for (int col = row; col < n; col++) {
                triangle[row + 1][col + 1] = triangle[row][col] + triangle[row][col + 1];
            }
        }

        return triangle[n][n];
    }
}
