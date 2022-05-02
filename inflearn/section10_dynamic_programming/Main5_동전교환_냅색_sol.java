package practice.inflearn.section10_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Main5_동전교환_냅색 {
    public static void main(String[] args) {
        Main5_동전교환_냅색 main = new Main5_동전교환_냅색();

        Scanner in = new Scanner(System.in);
        int coinKind = in.nextInt();
        int[] coins = new int[coinKind];
        for (int i = 0; i < coinKind; i++) {
            coins[i] = in.nextInt();
        }
        int change = in.nextInt();

        int solution = main.solution(coins, change);
        System.out.println(solution);
    }

    public static int solution(int[] coins, int change) {
        Arrays.sort(coins);
        int[] coinCounts = new int[change + 1];  // i의 돈을 만들기 위해 필요한 최소 동전 개수
        Arrays.fill(coinCounts, Integer.MAX_VALUE);
        coinCounts[0] = 0;
        for (int coin : coins) {
            for (int money = coin; money <= change; money++) {
                coinCounts[money] = Math.min(coinCounts[money], coinCounts[money - coin] + 1);
            }
        }

        return coinCounts[change];
    }
}
