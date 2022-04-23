package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Main6 main = new Main6();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        int[] solution = main.solution(n, heights);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, int[] heights) {
        int[] answer = new int[2];
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (copy[i] != heights[i]) {
                answer[idx++] = i + 1;
            }
        }

        return answer;
    }
}
