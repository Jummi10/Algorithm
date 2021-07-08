package practice.baekjoon.정수론;

import java.io.*;
import java.util.*;

// 11653 success
public class 소인수분해 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int number = Integer.parseInt(st.nextToken());

        if (number == 1) {
            return;
        }

        int BOUND = number;
        boolean[] isPrime = new boolean[BOUND + 1];
        Arrays.fill(isPrime, true);

        for (int prime = 2; prime <= BOUND && number > 1; prime++) {
            if (!isPrime[prime]) {
                continue;
            }

            // 에라토스테네스의 체: 소수가 아닌 수 걸러내기
            for (int mul = 2; prime * mul <= BOUND; mul++) {
                isPrime[prime * mul] = false;
            }

            // 소인수분해
            while (number % prime == 0) {
                primes.add(prime);
                number /= prime;
            }
        }

        /* list.toArray()
        1. List를 toArray 메서드에 파라메터로 넘어가는 배열 객체의 size만큼의 배열로 전환한다.
        2. 단, 해당 List size가 인자(0)로 넘어가는 배열 객체의 size(primes.size())보다 클때, 해당 List의 size로 배열이 만들어진다.
        3. 반대로 해당 List size가 인자로 넘어가는 배열객체의 size보다 작을때는, 인자로 넘어가는 배열객체의 size로 배열이 만들어진다.
         */
        Integer[] answer = primes.toArray(new Integer[0]);
        Arrays.sort(answer);

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}
