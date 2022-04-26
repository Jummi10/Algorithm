package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main10 {   // 미로 경로의 수
    private static final int BOARD_LENGTH = 7;
    private static final int DIRECTION_COUNT = 4;
    private static final int[] dR = {-1, 0, 1, 0};
    private static final int[] dC = {0, 1, 0, -1};
    private static int count = 0;

    public static void main(String[] args) {
        Main10 main = new Main10();

        Scanner in = new Scanner(System.in);
        int[][] board = new int[BOARD_LENGTH + 2][BOARD_LENGTH + 2];
        for (int i = 0; i < BOARD_LENGTH + 2; i++) {
            for (int j = 0; j < BOARD_LENGTH + 2; j++) {
                if (i == 0 || i == BOARD_LENGTH + 1 || j == 0 || j == BOARD_LENGTH + 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = in.nextInt();
                }
            }
        }

        main.solution(board);
        System.out.println(count);
    }

    public static void solution(int[][] board) {
        boolean[][] isVisited = new boolean[BOARD_LENGTH + 2][BOARD_LENGTH + 2];
        isVisited[1][1] = true;
        route(board, isVisited, 1, 1);
    }

    private static void route(int[][] board, boolean[][] isVisited, int row, int col) {
        if (row == BOARD_LENGTH && col == BOARD_LENGTH) {
            count++;
            return;
        }

        for (int i = 0; i < DIRECTION_COUNT; i++) {
            int nextRow = row + dR[i];
            int nextCol = col + dC[i];
            if (!isVisited[nextRow][nextCol] && board[nextRow][nextCol] == 0) {
                isVisited[nextRow][nextCol] = true;
                route(board, isVisited, nextRow, nextCol);
                isVisited[nextRow][nextCol] = false;
            }
        }
    }
}
