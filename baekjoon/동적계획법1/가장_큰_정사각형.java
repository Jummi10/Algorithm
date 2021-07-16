package practice.baekjoon.동적계획법1;

import java.io.*;
import java.util.StringTokenizer;

// 1915 success
public class 가장_큰_정사각형 {
    // fail 원인: 입력이 모두 0인 경우를 고려하면 width 초기화를 1로 시키면 안 된다!
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = getLine();
        int row = parseInt(st), column = parseInt(st);  // 1<= r,c <= 1000
        int width = 0;

        if (row == 1 || column == 1) {
            width = 1;
            printResult(width);
            return;
        }
        int[][] table = new int[row + 1][column + 1];   // r=0, c=0 일 경우 0을 padding

        for (int r = 1; r <= row; r++) {
            String input = getLine().nextToken();

            for (int c = 1; c <= column; c++) {
                table[r][c] = input.charAt(c - 1) - '0';    // 입력

                if (table[r][c] == 1) {
                    // 오른쪽, 위쪽, 오른쪽 위 대각선 중 가장 작은 값
                    // 1. 셋 다 1이면 min = 1이니까 정사각형 완성
                    // 2. 하나라도 0이면 정사각형 만들지 못함
                    table[r][c] += Math.min(Math.min(table[r - 1][c], table[r][c - 1]), table[r - 1][c - 1]);
                    width = Math.max(width, table[r][c]);
                }
            }
        }

        /* 확인
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= column; c++) {
                System.out.print(table[r][c] + " ");
            }
            System.out.println();
        }*/

        printResult(width);
    }

    private static StringTokenizer getLine() throws IOException {
        return new StringTokenizer(READER.readLine());
    }

    private static int parseInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static void printResult(int width) throws IOException {
        WRITER.write(String.valueOf(width * width));
        WRITER.newLine();
        WRITER.flush();
        WRITER.close();
    }
}
