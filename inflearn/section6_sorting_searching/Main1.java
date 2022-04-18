package practice.inflearn.section6_sorting_searching;

import java.util.Scanner;

public class Main1 {
    // 선택 정렬
    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        int[] solution = main.solution(n, array);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, int[] array) {
        int minValue, minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            minValue = array[minIndex];

            for (int j = i + 1; j < n; j++) {
                if (minValue > array[j]) {
                    minIndex = j;
                    minValue = array[minIndex];
                }
            }

            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        return array;
    }
}
