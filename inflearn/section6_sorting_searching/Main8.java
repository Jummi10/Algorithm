package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Main8 main = new Main8();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        int solution = main.solution(n, target, numbers);
        System.out.println(solution);
    }

    public static int solution(int n, int target, int[] numbers) {
        Arrays.sort(numbers);
        int left = 0, right = n - 1, middle = (left + right) / 2;

        while (left <= right) {
            middle = (left + right) / 2;
            if (numbers[middle] == target) {
                break;
            }

            if (numbers[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return middle + 1;
    }
}
