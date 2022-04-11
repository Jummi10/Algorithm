package practice.inflearn.section2_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Main12 main = new Main12();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // 학생 수
        int m = in.nextInt();   // 수학테스트 횟수
        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            table[i] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                table[i][j] = in.nextInt();
            }
        }

        int solution = main.solution(n, m, table);
        System.out.println(solution);
    }

    public static int solution(int studentNumber, int testCount, int[][] table) {
        boolean[][] isTeams = new boolean[studentNumber + 1][studentNumber + 1]; // 행: 멘토, 열: 멘티
        int[] firstTestGrades = table[1];
        for (int i = 1; i <= studentNumber - 1; i++) {
            for (int j = i + 1; j <= studentNumber; j++) {
                isTeams[firstTestGrades[i]][firstTestGrades[j]] = true;
            }
        }

        for (int t = 2; t <= testCount; t++) {
            int[] grades = table[t];
            for (int i = 1; i <= studentNumber - 1; i++) {
                for (int j = i + 1; j <= studentNumber; j++) {
                    if (!isTeams[grades[i]][grades[j]]) {
                        isTeams[grades[j]][grades[i]] = false;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= studentNumber; i++) {
            for (int j = 1; j <= studentNumber; j++) {
                if (isTeams[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}