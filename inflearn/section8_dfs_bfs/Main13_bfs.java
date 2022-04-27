package practice.inflearn.section8_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13_bfs {
    private static final int DIRECTION_COUNT = 8;
    private static final int[] dR = {-1, -1, -1, 0, 1, 1, 1, 0};    // 왼위 대각선부터 시계방향
    private static final int[] dC = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Main13_bfs main = new Main13_bfs();

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
        for (int r = 1; r < mapLength + 1; r++) {
            for (int c = 1; c < mapLength + 1; c++) {
                if (!isVisited[r][c]) {
                    findOneIsland(isVisited, mapLength, r, c);
                    islandCount++;
                }
            }
        }

        System.out.println(islandCount);
    }

    private static void findOneIsland(boolean[][] isVisited, int mapLength, int firstRow, int firstCol) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(firstRow, firstCol));
        isVisited[firstRow][firstCol] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            for (int d = 0; d < DIRECTION_COUNT; d++) {
                int nextRow = current.row + dR[d];
                int nextCol = current.col + dC[d];
                if (nextRow >= 1 && nextRow <= mapLength && nextCol >= 1 && nextCol <= mapLength && !isVisited[nextRow][nextCol]) {
                    isVisited[nextRow][nextCol] = true;
                    queue.add(new Location(nextRow, nextCol));
                }
            }
        }
    }

    static class Location {
        private final int row;
        private final int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
