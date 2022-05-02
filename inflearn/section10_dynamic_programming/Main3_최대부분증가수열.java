package practice.inflearn.section10_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Main3_최대부분증가수열 {
    public static void main(String[] args) {
        Main3_최대부분증가수열 main = new Main3_최대부분증가수열();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = in.nextInt();
        }

        int solution = main.solution(n, permutation);
        System.out.println(solution);
    }

    public static int solution(int n, int[] permutation) {
        int[] dp = new int[n];  // i번째 숫자를 마지막 항으로 하는 최대증가수열의 길이
        dp[0] = 1;
        boolean isSmallest;
        int largestBeforeMe;

        for (int i = 1; i < n; i++) {
            isSmallest = true;
            largestBeforeMe = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (permutation[j] < permutation[i] && largestBeforeMe < dp[j]) {
                    largestBeforeMe = dp[j];
                    isSmallest = false;
                }
            }

            if (isSmallest) {
                dp[i] = 1;
            } else {
                dp[i] = largestBeforeMe + 1;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
