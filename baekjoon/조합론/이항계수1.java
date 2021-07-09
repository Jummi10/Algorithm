package practice.baekjoon.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11050 success
public class 이항계수1 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // nCk = n! / (n-k)! k! = (n * n-1 * n-2 * ... * n-k+1) / (1 * 2 * 3 * ... * k)

        int answer = factorial(n) / (factorial(n - k) * factorial(k));

        System.out.println(answer);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }
}
