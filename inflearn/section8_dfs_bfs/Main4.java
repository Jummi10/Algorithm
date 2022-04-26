package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main4 {
    private static int n;
    private static int drawCount;

    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();   // 1~n까지의 구슬
        drawCount = in.nextInt();   // 중복 가능하게 구슬을 m번 뽑는다.

        main.solution();
    }

    public static void solution() {
        int[] permutation = new int[drawCount + 1];
        createPermutation(1, permutation);
    }

    private static void createPermutation(int level, int[] permutation) {
        if (level == drawCount + 1) {
            for (int i = 1; i <= drawCount; i++) {
                System.out.print(permutation[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            permutation[level] = i;
            createPermutation(level + 1, permutation);
        }
    }
}
