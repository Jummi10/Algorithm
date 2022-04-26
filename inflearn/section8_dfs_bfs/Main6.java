package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Main6 main = new Main6();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // 10 이하의 n개의 자연수
        int drawOpportunity = in.nextInt();   // 이 중 m개를 뽑아 일렬로 나열 (순열)
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        main.solution(n, drawOpportunity, nums);
    }

    public static void solution(int n, int drawOpportunity, int[] nums) {
        int[] drawNumbers = new int[drawOpportunity];
        boolean[] isVisited = new boolean[n];
        createPermutation(nums, drawNumbers, isVisited, n, drawOpportunity, 0);
    }

    private static void createPermutation(int[] nums, int[] drawNumbers, boolean[] isVisited, int n, int drawOpportunity, int drawCount) {
        if (drawCount == drawOpportunity) {
            for (int drawNumber : drawNumbers) {
                System.out.print(drawNumber + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                drawNumbers[drawCount] = nums[i];
                isVisited[i] = true;
                createPermutation(nums, drawNumbers, isVisited, n, drawOpportunity, drawCount + 1);
                isVisited[i] = false;
            }
        }
    }
}
