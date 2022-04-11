package practice.inflearn.section2_array;

import java.util.Scanner;

public class Main9_sol {
    public static void main(String[] args) {
        Main9_sol main = new Main9_sol();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = new int[n];
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int solution = main.solution(n, grid);
        System.out.println(solution);
    }

    public static int solution(int n, int[][] grid) {
        int maxSum = 0, rowSum, columnSum, rightSum = 0, leftSum = 0;
        for (int i = 0; i < n; i++) {
            // 행, 열
            rowSum = 0;
            columnSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
                columnSum += grid[j][i];
            }
            maxSum = getMax(maxSum, rowSum, columnSum);

            // 대각선
            rightSum += grid[i][i];
            leftSum += grid[i][n - (i + 1)];
        }
        maxSum = getMax(maxSum, rightSum, leftSum);

        return maxSum;
    }

    private static int getMax(int a, int b, int c) {
        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        return max;
    }
}