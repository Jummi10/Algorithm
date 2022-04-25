package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        main.recursiveBinary(n);
    }

    private static void recursiveBinary(int n) {
        if (n == 0) {
            return;
        }
        int quotient = n / 2;
        int remainder = n % 2;

        recursiveBinary(quotient);
        System.out.print(remainder);
    }
}