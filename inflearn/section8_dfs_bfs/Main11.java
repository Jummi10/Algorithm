package practice.inflearn.section8_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11 {   // 미로 최단거리
    private static final int BOARD_LENGTH = 7;
    private static final int DIRECTION_COUNT = 4;
    private static final int[] dR = {-1, 0, 1, 0};
    private static final int[] dC = {0, 1, 0, -1};
    private static final int FAIL = -1;

    public static void main(String[] args) {
        Main11 main = new Main11();

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
    }

    public static void solution(int[][] board) {
        boolean[][] isVisited = new boolean[BOARD_LENGTH + 2][BOARD_LENGTH + 2];
        isVisited[1][1] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        int move = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.row == BOARD_LENGTH && current.col == BOARD_LENGTH) {
                    System.out.println(move);
                    return;
                }

                for (int d = 0; d < DIRECTION_COUNT; d++) {
                    Point next = new Point(current.row + dR[d], current.col + dC[d]);
                    if (!isVisited[next.row][next.col] && board[next.row][next.col] == 0) {
                        isVisited[next.row][next.col] = true;
                        queue.add(next);
                    }
                }
            }

            move++;
        }

        System.out.println(FAIL);
    }

    static class Point {
        final int row;
        final int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
