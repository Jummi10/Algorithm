package practice.inflearn.section2_array;

import java.util.Scanner;

public class Main10 {

    public static final int[] dx = {0, 1, 0, -1};   // UP, RIGHT, DOWN, LEFT
    public static final int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Main10 main = new Main10();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            grid[i] = new int[n + 2];
            if (i != 0 && i != n + 1) {
                for (int j = 1; j <= n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
        }

        int solution = main.solution(n, grid);
        System.out.println(solution);
    }

    public static int solution(int n, int[][] grid) {
        int count = 0;
        boolean[][] isPeak = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isPeak[i - 1][j] || isPeak[i][j - 1]) {   // 바로 위쪽, 왼쪽이 봉우리라면 자신은 봉우리가 될 수 없다.
                    continue;
                }

                int height = grid[i][j];
                isPeak[i][j] = true;
                // U{0,-1} R{1,0} D{0,1} L{-1,0}
                for (int k = 0; k < 4; k++) {
                    if (height <= grid[i + dx[k]][j + dy[k]]) {
                        isPeak[i][j] = false;
                        break;
                    }
                }

                if (isPeak[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}