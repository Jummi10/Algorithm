package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        main.recursive(n);
    }

    private static void recursive(int n) {
        if (n == 0) {
            return;
        }
        recursive(n - 1);
        System.out.println(n);
    }
}