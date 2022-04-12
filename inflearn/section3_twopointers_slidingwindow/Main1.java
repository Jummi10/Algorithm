package practice.inflearn.section3_twopointers_slidingwindow;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();

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
        int[] answer = new int[n + m];
        for (int idx = 0, i = 0, j = 0; idx < n + m && i <= n && j <= m; ) {
            if (i == n) {
                for (int k = j; k < m; k++) {
                    answer[idx++] = b[k];
                }
                break;
            }
            if (j == m) {
                for (int k = i; k < n; k++) {
                    answer[idx++] = a[k];
                }
                break;
            }

            if (a[i] < b[j]) {
                answer[idx++] = a[i++];
            } else if (a[i] > b[j]) {
                answer[idx++] = b[j++];
            } else {
                answer[idx++] = a[i++];
                answer[idx++] = b[j++];
            }
        }

        return answer;
    }
}
