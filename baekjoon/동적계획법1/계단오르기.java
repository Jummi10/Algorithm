package practice.baekjoon.동적계획법1;

import java.io.*;

//2579 success
public class 계단오르기 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] scores;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        int n = initialize();   // 계단 개수

        dp[1][0] = dp[1][1] = scores[1];
        for (int i = 2; i <= n; i++) {
            dp[i][1] = scores[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
            dp[i][0] = scores[i] + dp[i - 1][1];    // 연속된 세 계단 X = 연속 두번 1계단씩 올라갈 수 X
        }

        WRITER.write(String.valueOf(Math.max(dp[n][0], dp[n][1])));
        WRITER.newLine();
        WRITER.flush();
        WRITER.close();
    }

    private static int initialize() throws IOException {
        int n = input();
        scores = new int[n + 1];  // 시작점: index=0, score=0
        dp = new int[n + 1][2]; //[i][0]: 1계단을 밟고 i번째 계단으로 왔을 경우 최대, [i][1]: 2계단을 밟고 i로 왔을 경우 최대

        for (int i = 1; i <= n; i++) {
            scores[i] = input();
        }

        return n;
    }

    private static int input() throws IOException {
        return Integer.parseInt(READER.readLine().trim());
    }
}
