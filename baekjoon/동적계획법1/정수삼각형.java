package practice.baekjoon.동적계획법1;

import java.io.*;
import java.util.StringTokenizer;

// 1932 success
public class 정수삼각형 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] triangle;

    public static void main(String[] args) throws IOException {
        int n = input(new StringTokenizer(""));
        dp(n);
        int max = getMax(n);

        WRITER.write(String.valueOf(max));
        WRITER.newLine();
        WRITER.flush();
        WRITER.close();
    }

    private static int input(StringTokenizer st) throws IOException {
        int n = Integer.parseInt(READER.readLine().trim());
        triangle = new int[n + 1][n + 1];   // 0 row, 0 column = padding

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(READER.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return n;
    }

    private static void dp(int n) {
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
    }

    private static int getMax(int n) {
        int max = -1;
        for (int j = 1; j <= n; j++) {
            if (max < triangle[n][j]) {
                max = triangle[n][j];
            }
        }
        return max;
    }
}
