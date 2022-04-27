package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main13_dfs {
    private static final int DIRECTION_COUNT = 8;
    private static final int[] dR = {-1, -1, -1, 0, 1, 1, 1, 0};    // 왼위 대각선부터 시계방향
    private static final int[] dC = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Main13_dfs main = new Main13_dfs();

        Scanner in = new Scanner(System.in);
        int mapLength = in.nextInt();
        int[][] map = new int[mapLength + 2][mapLength + 2];
        for (int r = 0; r < mapLength + 2; r++) {
            for (int c = 0; c < mapLength + 2; c++) {
                if (r == 0 || r == mapLength + 1 || c == 0 || c == mapLength + 1) {
                    map[r][c] = 0;
                } else {
                    map[r][c] = in.nextInt();
                }
            }
        }

        main.solution(mapLength, map);
    }

    public static void solution(int mapLength, int[][] map) {
        boolean[][] isVisited = new boolean[mapLength + 2][mapLength + 2];
        for (int r = 0; r < mapLength + 2; r++) {
            for (int c = 0; c < mapLength + 2; c++) {
                if (map[r][c] == 0) {
                    isVisited[r][c] = true;
                }
            }
        }

        int islandCount = 0;
        for (int r = 1; r <= mapLength; r++) {
            for (int c = 1; c <= mapLength; c++) {
                if (!isVisited[r][c]) {
                    // System.out.println("row: " + r + " , column: " + c);
                    findOneIsland(map, isVisited, mapLength, r, c);
                    islandCount++;
                }
            }
        }

        System.out.println(islandCount);
    }

    private static void findOneIsland(int[][] map, boolean[][] isVisited, int mapLength, int row, int col) {
        if (row == 0 || row == mapLength + 1 || col == 0 || col == mapLength + 1) {
            return;
        }

        boolean isEnd = true;
        for (int d = 0; d < DIRECTION_COUNT; d++) {
            int nextRow = row + dR[d];
            int nextCol = col + dC[d];
            if (nextRow > 0 && nextRow < mapLength + 1 && nextCol > 0 && nextCol < mapLength + 1 && !isVisited[nextRow][nextCol]) { // 한 군데라도 안 들른 곳이 있다면
                isEnd = false;
                break;
            }
        }
        if (isEnd) {
            return;
        }

        for (int d = 0; d < DIRECTION_COUNT; d++) {
            int nextRow = row + dR[d];
            int nextCol = col + dC[d];
            if (nextRow > 0 && nextRow < mapLength + 1 && nextCol > 0 && nextCol < mapLength + 1 && !isVisited[nextRow][nextCol]) {
                isVisited[nextRow][nextCol] = true;
                findOneIsland(map, isVisited, mapLength, nextRow, nextCol);
            }
        }
    }
}
