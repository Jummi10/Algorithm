package practice.baekjoon.동적계획법1;

import java.io.*;
import java.util.StringTokenizer;

// 11660 success
public class 구간합_구하기5 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] table;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer("");
        int[] init = initialize(st);
        int n = init[0], testcase = init[1];

        sumDP(n);

        for (int tc = 0; tc < testcase; tc++) {
            st = getLine();
            int x1 = parseInt(st), y1 = parseInt(st), x2 = parseInt(st), y2 = parseInt(st);

            int answer = table[x2][y2] - table[x1 - 1][y2] - table[x2][y1 - 1] + table[x1 - 1][y1 - 1];
            WRITER.write(String.valueOf(answer));
            WRITER.newLine();
        }

        WRITER.flush();
        WRITER.close();
    }

    private static int[] initialize(StringTokenizer st) throws IOException {
        st = getLine();
        int n = parseInt(st);   // 표의 크기
        int testcase = parseInt(st);   // testcase
        table = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = getLine();
            for (int j = 1; j <= n; j++) {
                table[i][j] = parseInt(st);
            }
        }
        return new int[] {n, testcase};
    }

    private static void sumDP(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // [0][0]~[i][j]까지의 합
                table[i][j] += table[i - 1][j] + table[i][j - 1] - table[i - 1][j - 1];
            }
        }
    }

    private static StringTokenizer getLine() throws IOException {
        return new StringTokenizer(READER.readLine());
    }

    private static int parseInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
