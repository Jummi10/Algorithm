package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2725 fail - 시간초과
public class 보이는_점의_개수 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = input();

        for (int i = 0; i < tc; i++) {
            int n = input();
            int count = 3;  // (0,1) (1,0) (1,1)

            for (int x = 1; x <= n; x++) {
                for (int y = 1; y < x; y++) { // y=x 아래 구역만 살펴보고 2배
                    if (gcd(x, y) == 1) {
                        count += 2;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static int input() throws IOException {
        return Integer.parseInt(READER.readLine().trim());
    }

    private static int gcd(int a, int b) { // 최대공약수
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
