package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1644 success
public class 소수의_연속합_완전탐색 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int number = Integer.parseInt(st.nextToken());
        filterNonPrimes(number);

        int count = 0;
        for (int i = 2; i <= number / 2; i++) {
            if (!isPrime[i]) {
                continue;
            }

            if (canConsecutiveSumMakeNumber(number, i)) {  // i 부터의 연속된 소수 합으로 number를 나타낼 수 있느냐
                count++;
            }
        }

        if (isPrime[number]) {  // 자기 자신이 합일 경우 ex> 41 = 41
            count++;
        }

        System.out.println(count);
    }

    private static void filterNonPrimes(int n) {
        isPrime = new boolean[n + 1];   // 0 ~ n
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int p = 2; p <= n; p++) {
            if (!isPrime[p]) {
                continue;
            }

            for (int j = 2; p * j <= n; j++) {
                isPrime[p * j] = false;
            }
        }
    }

    private static boolean canConsecutiveSumMakeNumber(int n, int prime) {
        int number = n;
        for (int i = 0; i < n && 0 < number; i++) {
            if (isPrime[prime + i]) {
                number -= prime + i;
            }
        }
        return number == 0;
    }
}
