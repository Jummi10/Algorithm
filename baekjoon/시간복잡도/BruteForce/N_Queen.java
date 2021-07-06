package practice.baekjoon.알고리즘_기초.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9663 success
public class N_Queen {
    // queen: 상하좌우, 대각선으로 모두 갈 수 있음, 재귀(recursive)
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] chessBoard;
    private static int answer = 0, n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());    // n*n 체스판
        chessBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = -1;   // array fill
            }
        }

        placeChessPieces(0);
        System.out.println(answer);
    }

    private static void placeChessPieces(int line) {
        if (line == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (chessBoard[line][col] != -1) {
                continue;
            }
            chessBoard[line][col] = line;

            // 좌우
            for (int j = 0; j < n; j++) {
                if (chessBoard[line][j] == -1) {
                    chessBoard[line][j] = line;
                }
            }
            // 하
            for (int row = 0; row < n; row++) {
                if (chessBoard[row][col] == -1) {
                    chessBoard[row][col] = line;
                }
            }
            // 왼쪽 아래 대각선
            for (int x = line, y = col; x < n && y >= 0; x++, y--) {
                if (chessBoard[x][y] == -1) {
                    chessBoard[x][y] = line;
                }
            }
            // 오른쪽 아래 대각선
            for (int x = line, y = col; x < n && y < n; x++, y++) {
                if (chessBoard[x][y] == -1) {
                    chessBoard[x][y] = line;
                }
            }

            placeChessPieces(line + 1);

            // 현재 queen이 처리한 흔적 지운다.
            // 좌우
            for (int j = 0; j < n; j++) {
                if (chessBoard[line][j] == line) {
                    chessBoard[line][j] = -1;
                }
            }
            // 하
            for (int row = 0; row < n; row++) {
                if (chessBoard[row][col] == line) {
                    chessBoard[row][col] = -1;
                }
            }
            // 왼쪽 아래 대각선
            for (int x = line, y = col; x < n && y >= 0; x++, y--) {
                if (chessBoard[x][y] == line) {
                    chessBoard[x][y] = -1;
                }
            }
            // 오른쪽 아래 대각선
            for (int x = line, y = col; x < n && y < n; x++, y++) {
                if (chessBoard[x][y] == line) {
                    chessBoard[x][y] = -1;
                }
            }
        }
    }
}
