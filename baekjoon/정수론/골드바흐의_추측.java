package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6588 success
public class 골드바흐의_추측 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String WRONG = "Goldbach's conjecture is wrong.\n";
    private static final int BOUND = 1000000;
    private static boolean[] isPrime = new boolean[BOUND];

    public static void main(String[] args) throws IOException {
        filterNonPrimes();

        StringBuilder builder = new StringBuilder();
        StringTokenizer st;
        int n;

        while (true) {
            st = new StringTokenizer(READER.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            int a = 0, b = 0;   // n = a + b, a와 b는 소수

            for (int i = 3; i < BOUND; i += 2) {
                if (isPrime[i] && isPrime[n - i]) {
                    a = i;
                    b = n - i;
                    break;
                }
            }

            if (a != 0) {
                builder.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
            } else {
                builder.append(WRONG);
            }
        }

        System.out.println(builder.toString());
    }

    private static void filterNonPrimes() {
        Arrays.fill(isPrime, true);

        for (int i = 2; i < BOUND; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = 2; i * j < BOUND; j++) {
                isPrime[i * j] = false;
            }
        }
    }
}
