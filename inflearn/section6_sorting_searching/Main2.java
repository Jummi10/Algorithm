package practice.inflearn.section6_sorting_searching;

import java.util.Scanner;

public class Main2 {
    // 버블 정렬
    public static void main(String[] args) {
        Main2 main = new Main2();

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
        // 가장 큰 수를 맨 뒤로 미는 방식
        for (int limit = n - 1; limit > 0; limit--) {
            for (int idx = 0; idx < limit; idx++) {
                if (array[idx] > array[idx + 1]) {
                    int temp = array[idx];
                    array[idx] = array[idx + 1];
                    array[idx + 1] = temp;
                }
            }
        }

        return array;
    }
}
