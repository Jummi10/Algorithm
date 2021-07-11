package practice.baekjoon.정수론;

import java.io.*;
import java.util.*;

// 1837 success
public class 암호제작 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String GOOD = "GOOD";
    private static final String BAD = "BAD";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        // 4 ≤ P ≤ 10^100 -> Integer 불가능(NumberFormatException)
        // 입력범위가 매우 클 때는 String으로 받는다
        String cipher = st.nextToken();
        int criterion = Integer.parseInt(st.nextToken());

        Integer[] primes = filterNonPrimes(criterion);

        for (Integer prime : primes) {
            if (isDivided(cipher, prime)) { // 암호가 k보다 작은 소수로 나누어진다면
                System.out.println(BAD + " " + prime);
                return;
            }
        }

        System.out.println(GOOD);
    }

    private static Integer[] filterNonPrimes(int n) {   // k보다 작은 소수
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            primes.add(i);

            for (int j = 2; i * j < n; j++) {  // 에라토스테네스의 체
                isPrime[i * j] = false;
            }
        }

        return primes.toArray(new Integer[0]);
    }

    private static boolean isDivided(String cipher, int prime) {
        char[] ciphers = cipher.toCharArray();
        int sum = 0;
        for (char c : ciphers) {
            sum = (sum * 10 + (c - '0')) % prime;
        }
        return sum == 0;
    }

    // 다른 사람 풀이: 에라토스테네스의 체로 소수 거르면서 바로 isDivided() 확인하기
    private static void solution(String cipher, int k) {
        boolean[] isPrime = new boolean[k];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < k; i++) {
            if (!isPrime[i]) {
                continue;
            }

            if (isDivided(cipher, i)) { // 암호가 k보다 작은 소수로 나누어진다면
                System.out.println(BAD + " " + i);
                return;
            }

            for (int j = 2; i * j < k; j++) {  // 에라토스테네스의 체
                isPrime[i * j] = false;
            }
        }

        System.out.println(GOOD);
    }
}
