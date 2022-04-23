package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main7_sol {
    public static void main(String[] args) {
        Main7_sol main = new Main7_sol();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] board = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            board[i] = new Point(x, y);
        }

        Point[] solution = main.solution(n, board);
        for (int i = 0; i < n; i++) {
            System.out.println(solution[i].toString());
        }
    }

    public static Point[] solution(int n, Point[] board) {
        Arrays.sort(board);

        return board;
    }

    static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}
