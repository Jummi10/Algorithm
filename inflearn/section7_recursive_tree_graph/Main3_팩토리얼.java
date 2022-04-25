package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main3_팩토리얼 {
    public static void main(String[] args) {
        Main3_팩토리얼 main = new Main3_팩토리얼();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int solution = main.factorial(n);
        System.out.println(solution);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}