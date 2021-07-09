package practice.baekjoon.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11050 시간초과
public class 이항계수1 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // nCk = n! / (n-k)! k! = (n * n-1 * n-2 * ... * n-k+1) / (1 * 2 * 3 * ... * k)
        int answer = 1;
        for (int i = n, j = 1; j <= k; i--, j++) {
            answer *= i;    // 분모
            answer /= j;    // 분자
        }

        System.out.println(answer);
    }
}
