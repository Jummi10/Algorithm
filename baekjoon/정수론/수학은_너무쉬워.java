package practice.baekjoon.정수론;

import java.io.*;
import java.util.*;

// 2904 success
public class 수학은_너무쉬워 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static int[] input;
    private static int[] totalPrimeCounts;
    private static int[][] primeCounts; // i 번째 수가 몇 개의 어떤 prime 의 곱으로 이루어졌는가

    public static void main(String[] args) throws IOException {
        int n = setInput();
        Integer[] primes = filterNonPrimes(Arrays.stream(input).max().getAsInt());  // n개의 수 중 최댓값보다 작은 소수들
        setPrimeCounts(n, primes);

        int maxScore = 1, minMoving = 0;    // 점수 = 종이에 적혀있는 모든 수의 최대공약수, 최소 몇 번 만에 최고 점수를 받을 수 있는지
        for (int p = 0; p < primes.length; p++) {   // totalPrimeCounts.length
            int gcdCount = totalPrimeCounts[p] / n;    // 소수가 n장의 종이에 골고루 분포되어야지 최대공약수가 높아진다.
            maxScore *= Math.pow(primes[p], gcdCount);

            for (int j = 0; j < n; j++) {
                if (0 < gcdCount - primeCounts[j][p]) { // 최대공약수를 만족시키기 위해 원래 수보다 몇 개의 소수가 모자란가
                    minMoving += gcdCount - primeCounts[j][p];
                }
            }
        }

        System.out.printf("%d %d", maxScore, minMoving);
    }

    private static int setInput() throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int n = Integer.parseInt(st.nextToken());
        input = new int[n];

        st = new StringTokenizer(READER.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        return n;
    }

    private static Integer[] filterNonPrimes(int n) {   // 에라토스테네스의 체
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n + 1; i++) {
            if (!isPrime[i]) {
                continue;
            }
            primes.add(i);

            for (int j = 2; i * j <= n; j++) {
                isPrime[i * j] = false;
            }
        }

        return primes.toArray(new Integer[0]);
    }

    private static void setPrimeCounts(int n, Integer[] primes) {
        int primeSize = primes.length;
        totalPrimeCounts = new int[primeSize];  // 소수 p가 전체 수들에 몇 개가 있는가
        primeCounts = new int[n][primeSize];    // n개의 input 중 i번째의 수에 각각 어떤 소수가 몇 개 있는지

        // 소인수분해
        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            for (int p = 0; p < primeSize; p++) {
                while (number % primes[p] == 0) {
                    totalPrimeCounts[p]++;
                    primeCounts[i][p]++;
                    number /= primes[p];
                }
            }
        }
    }
}
