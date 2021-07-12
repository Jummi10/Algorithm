package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2725 success
public class 보이는_점의_개수 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX = 1001;
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        initializeDP(); //  n*n일 때 개수

        int tc = input();
        for (int i = 0; i < tc; i++) {
            int n = input();
            System.out.println(dp[n]);
        }

    }

    private static int input() throws IOException {
        return Integer.parseInt(READER.readLine().trim());
    }

    private static void initializeDP() {
        dp[1] = 3;  // (0,1) (1,0) (1,1)
        for (int i = 2; i < MAX; i++) {
            int count = 0;
            for (int x = 1; x < i; x++) {
                if (gcd(x, i) == 1) {   // y/x 기울기가 더 이상 약분되지 않는다면
                    count += 2; // // y=x 윗 구역에서 x축과 평행한 선만 살펴보고 2배
                }
            }
            dp[i] = dp[i - 1] + count;
        }
    }

    private static int gcd(int a, int b) { // 최대공약수
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
