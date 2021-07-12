package practice.baekjoon.정수론;

import java.io.*;
import java.util.*;

// 1644 success
public class 소수의_연속합_두포인터 {
    /* 반례
    두포인터: 31092 -> 1    // 1813개, start prime: 461 // n/2까지만 primes를 사용할 경우 primes의 마지막 원소가 15541
    완전탐색: 31092 -> 2    // 소수 3350개, start prime: 461+~+~, "15541+15551(> 31092/2=15546)"
     */
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int number = Integer.parseInt(st.nextToken());

        Integer[] primes = filterNonPrimes(number);
        int count = calculateConsecutivePrimesSum(number, primes);
        /*if (isPrime[number]) {    // 두 포인터에서 알아서 해줌
            count++;
        }*/

        System.out.println(count);
    }

    private static Integer[] filterNonPrimes(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        List<Integer> primes = new ArrayList<>();

        for (int p = 2; p <= n; p++) {
            if (!isPrime[p]) {
                continue;
            }

            /*if (p <= n / 2) {    // ex> 10의 연속 소수 합을 구할 때 소수 5 이상부터는 자신보다 큰 소수와 더할 수 없으니까(wrong)
                primes.add(p);
            }*/
            primes.add(p);

            for (int j = 2; p * j <= n; j++) {
                isPrime[p * j] = false;
            }
        }

        return primes.toArray(new Integer[0]);
    }

    private static int calculateConsecutivePrimesSum(int number, Integer[] primes) {    // 두 포인로 연속된 합 구하기
        int count = 0;
        int sum = 0;
        for (int start = 0, end = 0; end < primes.length; end++) {
            sum += primes[end];

            while (number < sum) {
                sum -= primes[start];
                start++;
            }

            if (number == sum) {
                count++;
            }
        }

        return count;
    }
}
