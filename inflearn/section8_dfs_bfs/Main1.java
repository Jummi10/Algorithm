package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main1 {

    public static final String YES = "YES";
    public static final String NO = "NO";

    public static int n;
    public static int[] nums;
    public static int sum = 0;
    public static int halfTotalSum;
    private static boolean canSubsetSumHalf = false;

    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        main.solution(n, nums);
    }

    public static void solution(int n, int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        halfTotalSum = totalSum / 2;

        if (totalSum % 2 == 1) {
            System.out.println(NO);
            return;
        }

        sumSubset(0);

        if (canSubsetSumHalf) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
    }

    private static void sumSubset(int index) {
        if (canSubsetSumHalf || sum > halfTotalSum || index == n) {
            return;
        }
        if (sum == halfTotalSum) {
            canSubsetSumHalf = true;
            return;
        }

        sum += nums[index];
        sumSubset(index + 1);

        sum -= nums[index];
        sumSubset(index + 1);
    }
}
