package practice.inflearn.section2_array;

import java.util.*;

public class Main11 {
    public static void main(String[] args) {
        Main11 main = new Main11();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] table = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            table[i] = new int[6];
            for (int j = 1; j <= 5; j++) {
                table[i][j] = in.nextInt();
            }
        }

        int solution = main.solution(n, table);
        System.out.println(solution);
    }

    public static int solution(int studentNumber, int[][] table) {
        int[] sameClassFriends = new int[studentNumber + 1];
        for (int i = 1; i <= studentNumber; i++) {
            for (int j = i + 1; j <= studentNumber; j++) {
                for (int clss = 1; clss <= 5; clss++) {
                    if (table[i][clss] == table[j][clss]) { // i와 j가 적어도 1번이라도 같은 반인 적이 있다면
                        sameClassFriends[i]++;
                        sameClassFriends[j]++;
                        break;  // 2번 카운트하면 안 되니까 for문 나가기
                    }
                }
            }
        }

        // 임시 반장(max) 구하기
        int classPresidentIndex = 1;
        int max = sameClassFriends[classPresidentIndex];
        for (int i = 2; i <= studentNumber; i++) {
            if (max < sameClassFriends[i]) {
                classPresidentIndex = i;
                max = sameClassFriends[i];
            }
        }

        return classPresidentIndex;
    }
}