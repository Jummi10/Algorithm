package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main4_피보나치_재귀 {
    public static void main(String[] args) {
        Main4_피보나치_재귀 main = new Main4_피보나치_재귀();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // System.out.println(main.fibonacci(n));
        main.memoization(n);
    }

    // 1번 -> print 불가
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    // 2번 - 배열 사용
    public static int[] fibonacci;

    public static void memoization(int n) {
        fibonacci = new int[n + 1];
        fibonacciWithArray(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
    }

    public static int fibonacciWithArray(int n) {
        if (n == 1 || n == 2) {
            return fibonacci[n] = 1;
        }
        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        return fibonacci[n] = fibonacciWithArray(n - 2) + fibonacciWithArray(n-1);
    }
}