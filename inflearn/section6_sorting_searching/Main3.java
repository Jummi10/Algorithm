package practice.inflearn.section6_sorting_searching;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Main3 main = new Main3();

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
        int targetValue;
        int targetIndex;

        for (int limit = 1; limit < n; limit++) {
            targetValue = array[limit];
            targetIndex = limit;

            // (targetIndex ~ limit - 1) -> (targetIndex + 1 ~ limit)로 다 밀림
            for (int idx = limit - 1; idx >= 0; idx--) {
                if (array[idx] > targetValue) {
                    array[idx + 1] = array[idx];
                    targetIndex--;
                } else {
                    break;
                }
            }
            array[targetIndex] = targetValue;
        }

        return array;
    }
}
