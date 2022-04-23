package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Main7 main = new Main7();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][2];
        for (int i = 0; i < n; i++) {
            board[i] = new int[2];
            for (int j = 0; j < 2; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int[][] solution = main.solution(n, board);
        for (int i = 0; i < n; i++) {
            System.out.println(solution[i][0] + " " + solution[i][1]);
        }
    }

    public static int[][] solution(int n, int[][] board) {
        Arrays.sort(board, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        return board;
    }
}
