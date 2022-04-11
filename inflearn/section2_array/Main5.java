package practice.inflearn.section2_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Main5 main = new Main5();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int solution = main.solution(n);
        System.out.println(solution);
    }

    public static int solution(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // true 이면 소수
//        primes[0] = false;
//        primes[1] = false;
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                count++;
                /*for (int j = 2, k = j * i; k <= n; j++, k = j * i) {
                    primes[k] = false;
                }*/
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return count;
    }
}