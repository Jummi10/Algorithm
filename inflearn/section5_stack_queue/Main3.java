package practice.inflearn.section5_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][n];  // 게임 화면의 격자의 상태가 담긴 2차원 배열
        for (int i = 0; i < n; i++) {
            board[i] = new int[n];
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int m = in.nextInt();   // moves 배열 길이
        int[] moves = new int[m];   // 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열
        for (int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        int solution = main.solution(n, board, m, moves);
        System.out.println(solution);
    }

    public static int solution(int boardLength, int[][] board, int moveCount, int[] moves) {
        int[] highestIndices = new int[boardLength];  // board 각 줄에서 가장 높은 인형의 위치
        boolean isEmpty;
        for (int col = 0; col < boardLength; col++) {   //열
            isEmpty = true;
            for (int row = 0; row < boardLength; row++) {   //행
                if (board[row][col] != 0) {
                    highestIndices[col] = row;
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                highestIndices[col] = boardLength;
            }
        }

        Stack<Integer> basket = new Stack<>();
        int bombCount = 0;
        for (int i = 0; i < moveCount; i++) {
            int moveColumn = moves[i] - 1;

            if (highestIndices[moveColumn] == boardLength) { // 인형이 없는 곳에서 크레인을 작동시키는 경우
                continue;
            }

            int dollNum = board[highestIndices[moveColumn]][moveColumn];
            highestIndices[moveColumn] += 1;
            if (!basket.empty() && basket.peek() == dollNum) {
                basket.pop();
                bombCount++;
                continue;
            }
            basket.push(dollNum);
        }

        return bombCount * 2;
    }
}
