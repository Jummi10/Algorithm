package practice.inflearn.section3_twopointers_slidingwindow;

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
        int sum = 1;
        int count = 0;
        int left = 1, right = 2;

        for (; right <= (n / 2 + 1); right++) {
            sum += right;
            if (sum == n) {
                count++;
            }

            while (sum >= n && right - left >= 1) {
                sum -= left++;

                if (sum == n) {
                    count++;
                    break;
                } else if (sum < n) {
                    break;
                }
            }
        }

        return count;
    }
}
