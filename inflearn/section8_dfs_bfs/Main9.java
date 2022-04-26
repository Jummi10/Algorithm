package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Main9 main = new Main9();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // n까지의 자연수 중에서
        int drawOpportunity = in.nextInt();   // m개의 숫자를 고른다. (조합)

        main.solution(n, drawOpportunity);
    }

    public static void solution(int n, int m) {
        int[] combination = new int[m];

        createCombination(n, m, combination, 0);
    }

    private static void createCombination(int n, int drawOpportunity, int[] combination, int index) {
        if (index == drawOpportunity) { // 뽑기 기회를 모두 소진하면
            for (int c : combination) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }

        int nextNumber;
        if (index == 0) {
            nextNumber = 1;
        } else {
            nextNumber = combination[index - 1] + 1;
        }

        for (int i = nextNumber; i <= n; i++) {
            combination[index] = i;
            createCombination(n, drawOpportunity, combination, index + 1);
        }
    }
}
