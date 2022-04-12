package practice.inflearn.section3_twopointers_slidingwindow;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = in.nextInt();
        }

        int solution = main.solution(n, k, sales);
        System.out.println(solution);
    }

    public static int solution(int n, int k, int[] sales) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        int max = sum;

        for (int i = k; i < n; i++) {
            sum += sales[i] - sales[i - k];
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
