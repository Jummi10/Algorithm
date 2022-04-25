package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main6_부분집합_dfs {
    public static int n;
    public static boolean[] check;

    public static void main(String[] args) {
        Main6_부분집합_dfs main = new Main6_부분집합_dfs();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        check = new boolean[n + 1];

        main.dfs(1);
    }

    public static void dfs(int level) {
        if (level == n + 1) {
            // 부분 집합 만들기 종료
            for (int i = 1; i < level; i++) {
                if (check[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        // right
        check[level] = true;    // 해당 레벨의 숫자를 부분 집합에 넣는다.
        dfs(level + 1);

        // left
        check[level] = false;    // 해당 레벨의 숫자를 부분 집합에 넣지 않는다.
        dfs(level + 1);
    }
}