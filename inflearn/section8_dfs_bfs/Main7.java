package practice.inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Main7 main = new Main7();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();

        int solution = main.solution(n, r);
        System.out.println(solution);
    }

    public static int solution(int n, int r) {
        return getCombination(n, r);
    }

    private static int getCombination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }
        if (r == 1) {
            return n;
        }

        return getCombination(n - 1, r - 1) + getCombination(n - 1, r);
    }
}
