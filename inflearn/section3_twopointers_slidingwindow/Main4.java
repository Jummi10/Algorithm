package practice.inflearn.section3_twopointers_slidingwindow;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] progressions = new int[n];
        for (int i = 0; i < n; i++) {
            progressions[i] = in.nextInt();
        }

        int solution = main.solution(n, target, progressions);
        System.out.println(solution);
    }

    public static int solution(int n, int target, int[] progressions) {
        int count = 0;

        int sum = progressions[0];
        int leftPointer = 0, rightPointer = 1;   // sum = [leftPointer] + ~ + [rightPointer - 1]
        while (leftPointer <= rightPointer && rightPointer <= n) {
            if (sum == target) {
                count++;
                sum -= progressions[leftPointer++];
                continue;
            }

            if (rightPointer == n) {
                break;
            }

            if (sum < target) {
                sum += progressions[rightPointer++];
                continue;
            }

            sum -= progressions[leftPointer++];
        }

        return count;
    }
}
