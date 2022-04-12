package practice.inflearn.section3_twopointers_slidingwindow;

import java.util.Scanner;

public class Main4_sol {
    public static void main(String[] args) {
        Main4_sol main = new Main4_sol();

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
        int sum = 0, leftPointer = 0;

        for (int rightPointer = 0; rightPointer < n; rightPointer++) {
            sum += progressions[rightPointer];
            if (sum == target) {
                count++;
            }

            while (sum >= target) {
                sum -= progressions[leftPointer++];

                if (sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    break;
                }
            }
        }

        return count;
    }
}
