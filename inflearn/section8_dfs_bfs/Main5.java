package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main5 {
    private static int minCoinCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Main5 main = new Main5();

        Scanner in = new Scanner(System.in);
        int coinTypeNumber = in.nextInt();
        int[] coins = new int[coinTypeNumber];
        for (int i = 0; i < coinTypeNumber; i++) {
            coins[i] = in.nextInt();
        }
        int change = in.nextInt();

        main.solution(coins, change);
        System.out.println(minCoinCount);
    }

    public static void solution(int[] coins, int change) {
        sortReverse(coins);
        getMinCoinCount(coins, change, 0, 0);
    }

    private static void getMinCoinCount(int[] coins, int change, int sum, int coinCount) {
        if (sum == change && coinCount < minCoinCount) {
            minCoinCount = coinCount;
            return;
        }

        if (sum > change || coinCount >= minCoinCount) {
            return;
        }

        for (int coin : coins) {
            getMinCoinCount(coins, change, sum + coin, coinCount + 1);
        }
    }

    private static void sortReverse(int[] array) {
        int length = array.length;

        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
}
