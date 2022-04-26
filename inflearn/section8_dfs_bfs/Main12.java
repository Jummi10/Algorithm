package practice.inflearn.section8_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12 {
    private static final int RIPE = 1;
    private static final int UNRIPE = 0;
    private static final int BLANK = -1;

    private static final int DIRECTION_COUNT = 4;
    private static final int[] dR = {-1, 0, 1, 0};
    private static final int[] dC = {0, 1, 0, -1};

    public static void main(String[] args) {
        Main12 main = new Main12();

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();  // 가로 길이, col
        int width = in.nextInt();   // 세로 길이, row
        int[][] box = new int[width + 2][length + 2];
        for (int w = 0; w < width + 2; w++) {
            for (int l = 0; l < length + 2; l++) {
                if (w == 0 || w == width + 1 || l == 0 || l == length + 1) {
                    box[w][l] = BLANK;
                } else {
                    box[w][l] = in.nextInt();
                }
            }
        }

        main.solution(width, length, box);
    }

    public static void solution(int width, int length, int[][] box) {
        int totalTomatoCount = length * width;
        int ripeTomatoCount = 0;
        Queue<Space> queue = new LinkedList<>();

        for (int w = 1; w <= width; w++) {
            for (int l = 1; l <= length; l++) {
                if (box[w][l] == BLANK) {
                    totalTomatoCount--;
                }
                if (box[w][l] == RIPE) {
                    ripeTomatoCount++;
                    queue.add(new Space(w, l));
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty()) {
            if (ripeTomatoCount == totalTomatoCount) {
                System.out.println(day);
                return;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Space current = queue.poll();
                for (int d = 0; d < DIRECTION_COUNT; d++) {
                    Space next = new Space(current.row + dR[d], current.col + dC[d]);

                    int tomato = box[next.row][next.col];
                    if (tomato == UNRIPE) {
                        box[next.row][next.col] = RIPE;
                        ripeTomatoCount++;
                        queue.add(next);
                    }
                }
            }

            day++;
        }

        System.out.println(BLANK);
    }

    static class Space {
        final int row;
        final int col;

        public Space(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
