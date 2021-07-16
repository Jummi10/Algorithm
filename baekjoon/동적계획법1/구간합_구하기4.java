package practice.baekjoon.동적계획법1;

import java.io.*;
import java.util.StringTokenizer;

// 11659 success
public class 구간합_구하기4 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = getLine();
        int n = parseInt(st);
        int times = parseInt(st);
        int[] sum = new int[n + 1];  // 1~n

        st = getLine();
        for (int i = 1; i <= n; i++) {
            sum[i] = parseInt(st);
            sum[i] += sum[i - 1]; // dp
        }

        for (int t = 0; t < times; t++) {
            st = getLine();
            int start = parseInt(st);
            int end = parseInt(st);

            WRITER.write(String.valueOf(sum[end] - sum[start - 1]));
            WRITER.newLine();
        }

        WRITER.flush();
        WRITER.close();
    }

    private static StringTokenizer getLine() throws IOException {
        return new StringTokenizer(READER.readLine());
    }

    private static int parseInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
