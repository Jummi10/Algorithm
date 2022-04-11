package practice.inflearn.section2_array;

import java.util.Scanner;

public class Main11_오답 {
    // wrong
    public static void main(String[] args) {
        Main11_오답 main = new Main11_오답();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] table = new int[n][5];
        for (int i = 0; i < n; i++) {
            table[i] = new int[5];
            for (int j = 0; j < 5; j++) {
                table[i][j] = in.nextInt();
            }
        }

        int solution = main.solution(n, table);
        System.out.println(solution);
    }

    public static int solution(int studentNumber, int[][] table) {
        // 1. 1~5학년 동안 각 학년에 같은 반이었던 학생들 수를 각자 구하기
        int[][] counts = new int[5][9]; // 5학년 9반까지 있음
        for (int grade = 0; grade < 5; grade++) {   // grade 학년
            for (int clss = 0; clss < studentNumber; clss++) {   // class 반
                int classNumber = table[clss][grade];
                counts[grade][classNumber - 1]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.print((i+1) + "학년 | ");
            for (int j = 0; j < 9; j++) {
                System.out.print(counts[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        // 2. 각 학생 번호마다 학년별로 몇 명이 같은 반이었는지 다 구하기
        int[] sameClassFriends = new int[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            System.out.print("학생 번호 " + (i+1) + " | ");
            for (int grade = 0; grade < 5; grade++) {
                int i1 = counts[grade][table[i][grade] - 1];
                sameClassFriends[i] += i1;
                System.out.print(i1 + " + ");
            }
            System.out.println(" = " + sameClassFriends[i]);
        }
        System.out.println();
        System.out.println();

        // 3. 임시 반장(max) 구하기
        int classPresidentIndex = 0;
        int max = sameClassFriends[classPresidentIndex];
        for (int i = 1; i < studentNumber; i++) {
            if (max < sameClassFriends[i]) {
                classPresidentIndex = i;
                max = sameClassFriends[i];
            }
        }

        return classPresidentIndex + 1; // index는 0부터 시작
    }
}