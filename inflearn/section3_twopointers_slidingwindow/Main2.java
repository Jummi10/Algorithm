package practice.inflearn.section3_twopointers_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        int[] solution = main.solution(n, m, a, b);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, int m, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> answer = new ArrayList<>();

        // 1. for
        /*for (int i = 0, j = 0; i <= n && j <= m;) {
            if (i == n | j == m) {
                break;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                answer.add(a[i++]);
                j++;
            }
        }*/

        // 2. while
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                answer.add(a[i++]);
                j++;
            }
        }

        return listToArray(answer);
    }

    private static int[] listToArray(List<Integer> list) {
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
