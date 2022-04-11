package practice.inflearn.section2_array;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] solution = main.solution(n);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        return fibonacci;
    }
}